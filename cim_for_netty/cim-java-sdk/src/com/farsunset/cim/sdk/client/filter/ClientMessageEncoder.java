/**
 * probject:cim-server-sdk
 * @version 2.0
 * 
 * @author 3979434@qq.com
 */  
package com.farsunset.cim.sdk.client.filter;



import com.farsunset.cim.sdk.client.constant.CIMConstant;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;



/**
 *  客户端消息发送前进行编码,可在此加密消息
 *
 */
public class ClientMessageEncoder extends MessageToByteEncoder<Object>  {
 
	@Override
	protected void encode(ChannelHandlerContext ctx, Object message, ByteBuf out) throws Exception {
		out.writeBytes(message.toString().getBytes(CIMConstant.UTF8));
		out.writeByte(CIMConstant.MESSAGE_SEPARATE);
	}
	
	
	 
	
}
