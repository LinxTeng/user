package com.hoho.test.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeClient {
	public static void main(String[] args) {
		new Thread(new TimeClient().new TimeClientHandler("127.0.0.1", 8080), "TimeClient-001").start();

	}

	public class TimeClientHandler implements Runnable {
		private String host;
		private int port;
		private Selector selector;
		private SocketChannel socketChannel;
		private volatile boolean stop;

		public TimeClientHandler(String host, int port) {
			this.host = host == null ? "127.0.0.1" : host;
			this.port = port;
			try {
				selector = Selector.open();
				// 设置SocketChannel为非阻塞模式
				socketChannel = SocketChannel.open();
				socketChannel.configureBlocking(false);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}

		}

		@Override
		public void run() {
			try {
				doConnect();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			// 无限循环体内轮询准备就绪的key
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
							handleInput(key);
						} catch (Exception e) {
							if (key != null) {
								key.cancel();
								if (key.channel() != null) {
									key.channel().close();
								}
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(1);
				}

			}
			// 多路复用器关闭后，所有注册在上面的channel和Pipe等资源都会自动去注册并关闭，所以不需要重复释放资源。
			if (selector != null) {
				try {
					selector.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		private void doConnect() throws IOException {
			// 如果直接连接成功，则注册到多路复用器上，发送请求消息，读应答。
			if (socketChannel.connect(new InetSocketAddress(host, port))) {
				socketChannel.register(selector, SelectionKey.OP_READ);
				doWrite(socketChannel);
			} else {
				// 如果当前没有联机，说明物理链路还没有建立。则注册OP_CONNECT状态位,监听服务端的TCP ACK应答。
				socketChannel.register(selector, SelectionKey.OP_CONNECT);
			}
		}

		private void doWrite(SocketChannel sc) throws IOException {
			byte[] req = "query/time".getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
			writeBuffer.put(req);
			writeBuffer.flip();
			sc.write(writeBuffer);
			if (!writeBuffer.hasRemaining()) {
				System.out.println("向服务器发送命令成功");
			}
		}

		private void handleInput(SelectionKey key) throws IOException {
			if (key.isValid()) {
				// 判断是否连接成功
				SocketChannel sc = (SocketChannel) key.channel();
				// 判断连接结果，如果连接成功，注册读事件到多路复用器
				if (key.isConnectable()) {
					if (sc.finishConnect()) {
						sc.register(selector, SelectionKey.OP_READ);
						doWrite(sc);
					} else {
						System.exit(1);// 连接失败，进程退出
					}
				}
				// 异步读客户端请求消息到缓冲区。
				if (key.isReadable()) {
					// 无法预知应答流的大小，我们预分配1MB的缓冲区用于读取应答消息。
					ByteBuffer readBuffer = ByteBuffer.allocate(1024);
					int readBytes = sc.read(readBuffer);
					if (readBytes > 0) {
						readBuffer.flip();
						byte[] bytes = new byte[readBuffer.remaining()];
						readBuffer.get(bytes);
						String body = new String(bytes, "UTF-8");
						System.out.println("获取到:" + body);
						this.stop = true;
					} else if (readBytes < 0) {
						// 对端链路关闭
						key.cancel();
						sc.close();
					} else {
						;// 读到0字节，忽略
					}
				}
			}
		}
	}
}
