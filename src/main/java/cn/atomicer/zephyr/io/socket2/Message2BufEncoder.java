package cn.atomicer.zephyr.io.socket2;

import cn.atomicer.zephyr.io.coding.Encoder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * The message encode handler of the Netty handling process,
 * depending on the type of encoder, messages are encoded
 * into different byte array
 *
 * @author Rao-Mengnan
 *         on 2018/2/1.
 */
public class Message2BufEncoder<T> extends MessageToByteEncoder {
    private Encoder<T> encoder;

    public Message2BufEncoder(Encoder<T> encoder) {
        this.encoder = encoder;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object message, ByteBuf out) throws Exception {
        byte[] bytes = encoder.encode((T) message);
        out.writeBytes(bytes);
    }
}
