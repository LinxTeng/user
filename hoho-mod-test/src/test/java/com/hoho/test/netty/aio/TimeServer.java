package com.hoho.test.netty.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * NIO 2.0
 * 
 * @author Linx
 *
 */
public class TimeServer {
	public static void main(String[] args) {
		int port = 8080;
		AsyncTimeServerHandler timeServerHandler = new TimeServer().new AsyncTimeServerHandler(port);
		new Thread(timeServerHandler, "AIO-AsyncTimeServerHandler-001").start();

	}

	public class AsyncTimeServerHandler implements Runnable {
		private int port;

		CountDownLatch latch;

		AsynchronousServerSocketChannel asynchronousServerSocketChannel;

		public AsyncTimeServerHandler(int port) {
			this.port = port;
			try {
				asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
				asynchronousServerSocketChannel.bind(new InetSocketAddress(this.port));
				System.out.println("时间服务器已启动,端口号:" + this.port);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			latch = new CountDownLatch(1);
			doAccept();
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void doAccept() {
			asynchronousServerSocketChannel.accept(this, new TimeServer().new AcceptComptionHandler());
		}
	}

	public class AcceptComptionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

		@Override
		public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
			attachment.asynchronousServerSocketChannel.accept(attachment, this);
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			result.read(buffer, buffer, new ReadCompletionHandler(result));
		}

		@Override
		public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
			exc.printStackTrace();
			attachment.latch.countDown();

		}

	}

	public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
		private AsynchronousSocketChannel channel;

		public ReadCompletionHandler(AsynchronousSocketChannel channel) {
			if (this.channel == null) {
				this.channel = channel;
			}
		}

		@Override
		public void completed(Integer result, ByteBuffer attachment) {
			attachment.flip();
			byte[] body = new byte[attachment.remaining()];
			attachment.get(body);
			try {
				String req = new String(body, "UTF-8");
				System.out.println("时间服务器接收到消息：" + req);
				String currentTime = "query/time".equalsIgnoreCase(req)
						? new Date(System.currentTimeMillis()).toString()
						: "错误的命令";
				doWrite(currentTime);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void failed(Throwable exc, ByteBuffer attachment) {
			try {
				this.channel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void doWrite(String currentTime) {
			if (currentTime != null && currentTime.trim().length() > 0) {
				byte[] bytes = currentTime.getBytes();
				ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
				writeBuffer.put(bytes);
				writeBuffer.flip();
				channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {

					@Override
					public void completed(Integer result, ByteBuffer attachment) {
						// 如果没有发送完成，继续发送
						if (attachment.hasRemaining()) {
							channel.write(attachment, attachment, this);
						}
					}

					@Override
					public void failed(Throwable exc, ByteBuffer attachment) {
						try {
							channel.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
			}
		}
	}

}
