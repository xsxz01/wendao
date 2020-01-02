package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8247_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M8247_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_8247_0 object1 = (Vo_8247_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.portrait));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.pic_no));

        GameWriteTool.writeString2(writeBuf, object1.content);

        GameWriteTool.writeString(writeBuf, object1.secret_key);

        GameWriteTool.writeString(writeBuf, object1.name);

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.attrib));
    }

    public int cmd() {
        return 8247;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M8247_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */