package cn.luguangyi.javax.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.time.LocalDateTime;

/**
 * Created by luguangyi on 2018/3/31.
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String content = ((ByteBuf) msg).toString(Charset.defaultCharset());
        String response = LocalDateTime.now().toString() + ": " + content;
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        System.out.println("here is channelActive method.");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // TODO Auto-generated method stub
        // 当引发异常时关闭连接。
        ctx.close();
    }
}
