package com.linx.test.netty.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class TimeClient {
	public static void main(String[] args) throws InterruptedException {
		int port = 8080;
		new TimeClient().connect(port, "127.0.0.1");
	}

	public void connect(int port, String host) throws InterruptedException {
		// 配置客户端NIO线程组
		EventLoopGroup group = new NioEventLoopGroup();

		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChildChannelHandler());
			// 发起异步连接操作
			ChannelFuture f = b.connect(host, port).sync();

			// 等待客户端链路关闭
			f.channel().closeFuture().sync();
		} finally {
			// 优雅退出，释放NIO线程组
			group.shutdownGracefully();
		}
	}

	private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			// 客户端对于沾包和拆包的处理。
			ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
			ch.pipeline().addLast(new StringDecoder());
			ch.pipeline().addLast(new TimeClientHandler());
		}

	}

	public class TimeClientHandler extends ChannelHandlerAdapter {
		byte[] req;
		// byte[] req = "query/time".getBytes();

		// tcp链路建立成功之后，会调用。
		@Override
		public void channelActive(ChannelHandlerContext ctx) throws Exception {
			System.out.println("连接服务端成功");
			req = ("query/time" + System.getProperty("line.separator")).getBytes();
			ByteBuf message = null;
			for (int i = 0; i < 10; i++) {
				message = Unpooled.buffer(req.length);
				message.writeBytes(req);
				ctx.writeAndFlush(message);
			}
		}

		// 返回应答消息时会调用
		@Override
		public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
			// ByteBuf buf = (ByteBuf) msg;
			// byte[] req = new byte[buf.readableBytes()];
			// buf.readBytes(req);
			// String body = new String(req, "UTF-8");
			String body = (String) msg;
			System.out.println("现在的时间为：" + body);
		}

		@Override
		public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
			// 释放资源,打印错误信息
			System.err.println(cause.getMessage() + ":" + cause.getStackTrace());
			ctx.close();
		}

	}

}
