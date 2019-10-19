package com.linx.test.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * 使用非阻塞io实现的时间服务器
 * 
 * @author Linx
 *
 */
public class TimeServer {
	public static void main(String[] args) {
		int port = 8080;
		MultiplexerTimeServer timeServer = new TimeServer().new MultiplexerTimeServer(port);
		new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
	}

	public class MultiplexerTimeServer implements Runnable {
		private Selector selector;

		private ServerSocketChannel servChannel;

		private volatile boolean stop;

		public MultiplexerTimeServer(int port) {
			try {

				// 打开serverSocketChannel，用于监听客户端的连接，它是所有客户端连接的父管道
				servChannel = ServerSocketChannel.open();
				// 绑定监听端口,设置连接为非阻塞模式
				servChannel.configureBlocking(false);
				servChannel.socket().bind(new InetSocketAddress(port), 1024);
				// 创建reactor线程，创建多路复用器并启动线程
				selector = Selector.open();
				servChannel.register(selector, SelectionKey.OP_ACCEPT);
				System.out.println("时间查询服务已启动，端口号:" + port);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}

		public void stop() {
			this.stop = true;
		}

		@Override
		public void run() {
			// 多路复用器在线程run方法的无限循环体内轮询准备就绪的Key。
			while (!stop) {
				try {
					selector.select(1000);
					Set<SelectionKey> selectedKeys = selector.selectedKeys();
					Iterator<SelectionKey> it = selectedKeys.iterator();
					SelectionKey key = null;
					while (it.hasNext()) {
						key = it.next();
						it.remove();
						try {
							this.handleInput(key);
						} catch (Exception e) {
							if (key != null) {
								key.cancel();
								if (key.channel() != null) {
									key.channel().close();
								}
							}
							e.printStackTrace();
						}
					}
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
			// 多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动去注册并关闭，所以不需要重复释放资源
			if (selector != null) {
				try {
					selector.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 处理新接入的请求消息
		private void handleInput(SelectionKey key) throws IOException {
			if (key.isValid()) {
				if (key.isAcceptable()) {
					ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
					// 多路复用器监听到有新的客户端接入，处理新的接入请求，完成TCP三次握手，建立物理链路
					SocketChannel sc = ssc.accept();
					// 设置客户端链路为非阻塞模式
					sc.configureBlocking(false);
					// 新接入的客户端连接注册到Reactor线程的多路复用器上,监听读操作,读取客户端发送的网络消息
					sc.register(selector, SelectionKey.OP_READ);
				}
				if (key.isReadable()) {
					// 读取数据
					SocketChannel sc = (SocketChannel) key.channel();
					ByteBuffer readBuffer = ByteBuffer.allocate(1024);
					// 异步读取客户端请求消息到缓冲区
					int readBytes = sc.read(readBuffer);
					if (readBytes > 0) {
						readBuffer.flip();
						byte[] bytes = new byte[readBuffer.remaining()];
						readBuffer.get(bytes);
						String body = new String(bytes, "UTF-8");
						System.out.println("服务器接收到命令:" + body);
						String currentTime = "query/time".equalsIgnoreCase(body)
								? new Date(System.currentTimeMillis()).toString()
								: "错误的命令";
						doWrite(sc, currentTime);
					} else if (readBytes < 0) {
						// 对端链路关闭
						key.cancel();
						sc.close();
					} else {
						;// 读取0字节，忽略
					}
				}
			}
		}

		private void doWrite(SocketChannel channel, String response) throws IOException {
			if (response != null && response.trim().length() > 0) {
				byte[] bytes = response.getBytes();
				ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
				writeBuffer.put(bytes);
				writeBuffer.flip();
				channel.write(writeBuffer);
				System.out.println("向客户端发送时间成功!");
			}

		}
	}

}
