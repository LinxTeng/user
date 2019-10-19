package com.linx.test.netty.netty;

import io.netty.bootstrap.ServerBootstrap;
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
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class TimeServer {

	public void bind(int port) throws InterruptedException {
		// 配置服务端的NIO线程组
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
					.childHandler(new TimeServer().new ChildChannelHandler());
			// 绑定端口，同步等待成功
			ChannelFuture f = b.bind(port).sync();

			// 等待服务端监听端口关闭
			f.channel().closeFuture().sync();
		} finally {
			// 优雅退出，释放线程池资源
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel arg0) throws Exception {
			// 服务端解决tcp沾包问题。
			arg0.pipeline().addLast(new LineBasedFrameDecoder(1024));
			arg0.pipeline().addLast(new StringDecoder());
			// 编码解码器要放前面，否则没效果。
			arg0.pipeline().addLast(new TimeServerHandler());

		}

	}

	public static void main(String[] args) throws InterruptedException {
		int port = 8080;
		new TimeServer().bind(port);
	}

	// 服务端处理
	public class TimeServerHandler extends ChannelHandlerAdapter {
		@Override
		public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
			// ByteBuf buf = (ByteBuf) msg;
			// byte[] req = new byte[buf.readableBytes()];
			// buf.readBytes(req);
			// String body = new String(req, "UTF-8").substring(0,
			// req.length - System.getProperty("line.separator").length());
			String body = (String) msg;// 进行了沾包解码后直接就是String类型。
			System.out.println("时间服务器接收到命名:" + body);
			String currentTime = "query/time".equalsIgnoreCase(body)
					? new java.util.Date(System.currentTimeMillis()).toString()
					: "错误的命令";
			// 添加一个分割符
			currentTime = currentTime + System.getProperty("line.separator");
			ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
			ctx.write(resp);
		}

		@Override
		public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
			// 调用flush方法是把缓冲区中的消息全部写道SocketChannel中
			ctx.flush();
		}

		@Override
		public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
			System.err.println(cause.getMessage());
			ctx.close();
		}
	}
}
