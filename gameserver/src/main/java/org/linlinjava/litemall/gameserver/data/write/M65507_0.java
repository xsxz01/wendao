package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M65507_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Petbeibao> list = (List) object;

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(list.size()));

        for (int i = 0; i < list.size(); i++) {
            GameWriteTool.writeByte(writeBuf, Integer.valueOf(((Petbeibao) list.get(i)).no));

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(((Petbeibao) list.get(i)).id));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(((Petbeibao) list.get(i)).petShuXing.size()));
            Entry<Object, Object> entry;
            for (int j = 0; j < ((Petbeibao) list.get(i)).petShuXing.size(); j++) {
                PetShuXing petShuXing = (PetShuXing) ((Petbeibao) list.get(i)).petShuXing.get(j);
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(((PetShuXing) ((Petbeibao) list.get(i)).petShuXing.get(j)).no));

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(((PetShuXing) ((Petbeibao) list.get(i)).petShuXing.get(j)).type1));

                Map<Object, Object> map = new HashMap();
                map = UtilObjMapshuxing.PetShuXing(petShuXing);
                map.remove("no");
                map.remove("type1");


                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    entry = (Entry) it.next();
                    if ((!entry.getKey().equals("all_polar")) && (!entry.getKey().equals("upgrade_magic")) && (!entry.getKey().equals("upgrade_total"))) {

                        if ((entry.getValue().equals(Integer.valueOf(0))) && ((entry.getKey().equals("dex")) || (entry.getKey().equals("def")) || (entry.getKey().equals("mana")) || (entry.getKey().equals("parry")) || (entry.getKey().equals("accurate")) || (entry.getKey().equals("wiz")))) {
                            it.remove();
                        }

                        if (entry.getValue().equals(""))
                            it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectEntry : map.entrySet()) {
                    if (BuildFields.data.get((String) objectEntry.getKey()) != null) {
                        BuildFields.get((String) objectEntry.getKey()).write(writeBuf, objectEntry.getValue());
                    } else {
                        System.out.println(objectEntry.getKey());
                    }
                }
            }
        }
    }


    public int cmd() {
        return 65507;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M65507_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */