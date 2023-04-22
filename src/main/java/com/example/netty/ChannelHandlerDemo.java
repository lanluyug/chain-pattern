package com.example.netty;


/**
 * @see io.netty.channel.ChannelHandler
 * 在上面顶级接口下，又对责任分成了两类
 * @see io.netty.channel.ChannelOutboundHandler
 * @see io.netty.channel.ChannelInboundHandler
 * 而上述责任handler行为都在以下接口规定
 * @see io.netty.channel.ChannelPipeline
 * @see io.netty.channel.DefaultChannelPipeline
 *
 * 除了netty外，Spring Security、Apache Shiro都使用了责任链
 */
public class ChannelHandlerDemo {
}
