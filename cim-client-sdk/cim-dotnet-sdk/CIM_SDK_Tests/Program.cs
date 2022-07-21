using CIM_Standard;
using Google.Protobuf;
using System;
using System.Net.Sockets;
using static CIM_Standard.SocketHelper;

namespace CIM_SDK_Tests
{
     class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("-------------应用启动中-------------");
             CIMConnect("192.168.10.133",23456,ReceiveMessage).Wait();
        }

        public static void ReceiveMessage()
        {
            NetworkStream networkStream = client.GetStream();
            while (true)
            {
                byte[] buffer = new byte[3];
                networkStream.Read(buffer, 0, buffer.Length);
                int l = (buffer[1] & 0xff);
                int h = (buffer[2] & 0xff);
                int length = (l | h << 8);
                if (buffer[0] == PING_TYPE)
                {
                    byte[] msg = new byte[length];
                    networkStream.Read(msg, 0, msg.Length);
                    Pong().Wait();
                }
                else if (buffer[0] == REPLY_BODY)
                {
                    byte[] msg = new byte[length];
                    networkStream.Read(msg, 0, msg.Length);
                    ReplyBodyModel model = new ReplyBodyModel();
                    model.MergeFrom(msg);
                    Console.WriteLine(model.Key);
                }
                else if (buffer[0] == MESSAGE_TYPE)
                {
                    byte[] msg = new byte[length];
                    networkStream.Read(msg, 0, msg.Length);
                    MessageModel model = new MessageModel();
                    model.MergeFrom(msg);
                    Console.WriteLine(model.Content);
                }
            }
        }

    }
}
