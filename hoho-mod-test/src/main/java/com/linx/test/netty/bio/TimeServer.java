package com.linx.test.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实现一个功能:客户端查询服务器的时间
 * 
 * @author Linx
 *
 */
public class TimeServer {

	public static void main(String[] args) {
		int port = 8080;
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("时间查询服务器已启动,端口:" + port);
			Socket socket = null;
			while (true) {
				socket = server.accept();
				new Thread(new TimeServer().new TimeServerHandler(socket)).start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (server != null) {
				System.out.println("关闭服务器");
			}
		}
	}

	public class TimeServerHandler implements Runnable {
		private Socket socket;

		public TimeServerHandler(Socket socket) {
			super();
			this.socket = socket;
		}

		@Override
		public void run() {
			BufferedReader in = null;
			PrintWriter out = null;

			try {
				in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				out = new PrintWriter(this.socket.getOutputStream(), true);
				String body = null;
				String currentTime = null;
				while (true) {
					body = in.readLine();
					if (body == null) {
						break;
					}
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
					System.out.println("时间服务器接收到消息:" + body);
					currentTime = "query/time".equalsIgnoreCase(body) ? df.format(new Date()) : "错误请求";
					out.println(currentTime);
				}
			} catch (IOException e) {
				// 此处可使用try的语法糖
				// 关闭输入流
				if (in != null) {
					try {
						in.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				// 关闭输出流
				if (out != null) {
					out.close();
					out = null;
				}
				if (this.socket != null) {
					try {
						this.socket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					socket = null;
				}
			}
		}

	}

}
