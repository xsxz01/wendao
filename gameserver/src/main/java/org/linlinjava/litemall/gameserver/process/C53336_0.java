package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.springframework.stereotype.Service;


@Service
public class C53336_0
        implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
    }

    public int cmd() {
        return 53336;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C53336_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */