package cn.atomicer.zephyr.io.socket2;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;


/**
 * Initialize the processing of the client pipeline through
 * {@link HandlerCreator}
 *
 * @author Rao-Mengnan
 *         on 2018/2/1.
 */
public class SocketClientInitializer<I> extends ChannelInitializer<SocketChannel> {

    private HandlerCreator<I> handlerCreator;

    public SocketClientInitializer(HandlerCreator<I> handlerCreator) {
        this.handlerCreator = handlerCreator;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        if (handlerCreator == null) {
            throw new IllegalArgumentException("client creator must be not null");
        }

        ChannelPipeline pipeline = channel.pipeline();
        AbstractHandler<I> clientHandler = handlerCreator.createClientHandler();
        pipeline.addLast(clientHandler.getDecoder());
        pipeline.addLast(clientHandler.getEncoder());
        pipeline.addLast(clientHandler);
    }
}
