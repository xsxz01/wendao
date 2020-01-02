package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Party;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M8165_0;
import org.linlinjava.litemall.gameserver.data.write.M_MSG_CREATE_PARTY_SUCC;
import org.linlinjava.litemall.gameserver.data.write.M_MSG_PARTY_INFO;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.GameParty;
import org.linlinjava.litemall.gameserver.game.GameCore;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.PartyMgr;
import org.springframework.stereotype.Service;

@Service
public class CMD_CREATE_PARTY implements GameHandler {

    private void sendErr(String err){
        Vo_8165_0 vo_8165_0 = new Vo_8165_0();
        vo_8165_0.msg = err;
        vo_8165_0.active = 0;
        GameObjectChar.send(new M8165_0(), vo_8165_0);
    }

    @Override
    public void process(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf) {

        System.out.println("点击创建帮派");
        System.out.println("创建帮派");

        String name = GameReadTool.readString(paramByteBuf);
        String announce = GameReadTool.readString((paramByteBuf));


        Chara chara = GameObjectChar.getGameObjectChar().chara;
        if(chara.balance < 1000){
            this.sendErr("金币不足！");
            return;
        }
        PartyMgr partyMgr = GameCore.that.partyMgr;
        if(partyMgr.checkExist(name)){
            this.sendErr("帮派名字已被占用!");
            return;
        }
        Party newParty = new Party();
        newParty.setId(0);
        newParty.setName(name);
        newParty.setAnnounce(announce);
        newParty.setConstruction(0);
        newParty.setLevel(1);
        GameParty party = partyMgr.newParty(newParty, chara);


        chara.balance -= 1000;
        chara.partyId = party.id;
        chara.partyName = name;
        GameObjectChar.send(new M_MSG_CREATE_PARTY_SUCC(), name);
        GameObjectChar.send(new M_MSG_PARTY_INFO(), party);
    }

    @Override
    public int cmd() {
        return 0x800C;
    }
}
