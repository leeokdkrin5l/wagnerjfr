package com.farsunset.cim.server.filter;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ObjectDecoder;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.farsunset.cim.server.constant.CIMConstant;
import com.farsunset.cim.server.mutual.SentBody;
/**
 *  服务端接收消息解码，可在此解密消息
 *  @author 3979434@qq.com
 *
 */
public class ServerMessageDecoder extends ObjectDecoder  {
	protected final Logger logger = Logger.getLogger(ServerMessageDecoder.class.getSimpleName());
	public ServerMessageDecoder(ClassResolver classResolver) {
		super(classResolver);
	}

	@Override
	public Object decode(ChannelHandlerContext arg0, ByteBuf  buffer) throws Exception   {
		
		 
		int length = buffer.readableBytes();
		
		/**
		 * CIMConstant.MESSAGE_SEPARATE 为消息界限
		 * 当一次收到多个消息时，以此分隔解析多个消息
		 */
		if (buffer.isReadable()&&length > 0 &&  CIMConstant.MESSAGE_SEPARATE == buffer.getByte(length-1)) {
			
			byte[] data = new byte[length-1];
			buffer.readBytes(data);
			String message = new String(new String(data,CIMConstant.ENCODE_UTF8));
			logger.debug(message);
			buffer.readByte();
			
			SentBody body = parserMessageToSentBody(message);
	        data = null;
	        message = null;
	        return body;
		}
		
		/**
		 * CIMConstant.FLEX_DATA_SEPARATE 为FLEX客户端socket验证消息界限
		 * 
		 */
		if (buffer.isReadable()&& length > 0 &&  CIMConstant.FLEX_DATA_SEPARATE == buffer.getByte(length-1)) {
			
			byte[] data = new byte[length-1];
			buffer.readBytes(data);
			String message = new String(new String(data,CIMConstant.ENCODE_UTF8));
			System.out.println("[ServerMessageDecoder]:"+message);
			
			//将末尾的消息分隔符读取掉
			buffer.readByte();
			data = null;
			return message;
		}
        
		return null;
	}
	
	private SentBody  parserMessageToSentBody(String message) throws Exception
	{
		SentBody body = new SentBody();
		if(message.equals(CIMConstant.CMD_HEARTBEAT_RESPONSE))//如果是心跳响应，则让HeartbeatHandler去处理
		{
			body.setKey(CIMConstant.RequestKey.CLIENT_HEARTBEAT);
			return body;
		}
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
        DocumentBuilder builder = factory.newDocumentBuilder();  
        Document doc = builder.parse(new ByteArrayInputStream(message.toString().getBytes(CIMConstant.ENCODE_UTF8)));
        body.setKey(doc.getElementsByTagName("key").item(0).getTextContent());
        NodeList dataNodeList = doc.getElementsByTagName("data");
        if(dataNodeList!=null && dataNodeList.getLength()>0)
        {
	        NodeList items = dataNodeList.item(0).getChildNodes();  
	        for (int i = 0; i < items.getLength(); i++) {  
	            Node node = items.item(i);  
	            body.getData().put(node.getNodeName(), node.getTextContent());
	        }
        }
        
        return body;
	}

}
