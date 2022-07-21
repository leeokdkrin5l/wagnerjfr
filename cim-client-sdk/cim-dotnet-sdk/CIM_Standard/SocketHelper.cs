using Google.Protobuf;
using Google.Protobuf.Collections;
using System;
using System.IO;
using System.Net;
using System.Net.Sockets;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.Threading;
using System.Threading.Tasks;

namespace CIM_Standard
{
    public static class SocketHelper
    {
        public static TcpClient client = new TcpClient();

        public const byte PONG = 0;

        public const byte PING_TYPE = 1;

        public const byte MESSAGE_TYPE = 2;

        public const byte SEND_BODY = 3;

        public const byte REPLY_BODY = 4;

        public const int FORCE_LGOUT = 255;

        public const string APP_CHANNEL = "DotNet";

        public const string APP_VERSION = "1.0.0";

        public const string APP_PACKAGE = "com.farsunset.cim";

        public static bool LoginState = false;

        public async static Task CIMConnect(string host,int port,Action action) 
        {

            try
            {
                await client.ConnectAsync(host,port);


                while (true)
                {
                    Thread.Sleep(1000);
                    if (client.Connected)
                    {
                        LoginState = true;
                        Console.WriteLine("-------------------开始登录-------------");
                        await SendLoginMessage();
                        break;
                    }
                }

                await Task.Run(new Action(action));//开启线程，不停接收消息

            } 
            catch (Exception ex) 
            {
                Console.WriteLine(ex.Message);
            }
        }

    

        public async static Task Pong()
        {
            byte[] body = System.Text.Encoding.UTF8.GetBytes("PONG");
            byte[] header = createLengthHeader(PONG, body.Length);
            byte[] data = new byte[body.Length + 3];
            data[0] = header[0];
            data[1] = header[1];
            data[2] = header[2];
            body.CopyTo(data,3);
            await SendMessage(data);
        }

        public async static Task SendLoginMessage() 
        {
            try 
            {
                long timestamp =Convert.ToInt64 ((DateTime.UtcNow - new DateTime(1970, 1, 1, 0, 0, 0, 0)).TotalSeconds);
                var body = new SentBodyModel();
                body.Key = "client_bind";
                body.Timestamp = timestamp;
                body.Data.Add("uid", "111111111111");
                body.Data.Add("channel", APP_CHANNEL);
                body.Data.Add("appVersion", APP_VERSION);
                body.Data.Add("osVersion", "NetStandard2.0");
                body.Data.Add("packageName", APP_PACKAGE);
                body.Data.Add("deviceId", "34519adfsdsfdfdf");
                body.Data.Add("deviceName", "NetCore3.1");
                body.Data.Add("language", "Zh_cn");
                byte[] body_data = body.ToByteArray();
                byte[] data = new byte[body_data.Length + 3];
                byte[] header = createLengthHeader(SEND_BODY, body_data.Length);
                data[0] = header[0];
                data[1] = header[1];
                data[2] = header[2];
               body_data.CopyTo(data, 3);
                await SendMessage(data);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        private static async Task SendMessage(byte[] bytes) 
        {
            NetworkStream networkStream = client.GetStream();
            await networkStream.WriteAsync(bytes, 0, bytes.Length);
        }

        private static byte[] createLengthHeader(byte type, int length)
        {
            byte[] header = new byte[3];
            header[0] = type;
            header[1] = (byte)(length & 0xff);
            header[2] = (byte)((length >> 8) & 0xff);
            return header;
        }

       
    }
}
