//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.fight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linlinjava.litemall.gameserver.data.vo.Vo_19945_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_19959_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_64989_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_7655_0;
import org.linlinjava.litemall.gameserver.data.write.MSG_C_ACCEPT_HIT;
import org.linlinjava.litemall.gameserver.data.write.MSG_C_ACTION;
import org.linlinjava.litemall.gameserver.data.write.MSG_C_ACCEPT_MAGIC_HIT;
import org.linlinjava.litemall.gameserver.data.write.MSG_C_END_ACTION;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

/**
 * 障碍金-遗忘
 */
public class ZhangAiJin21Skill extends FightRoundSkill {
    public ZhangAiJin21Skill() {
    }

    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        new ArrayList();
        FightManager.getFightObject(fightContainer, fightRequest.vid);
        Vo_19959_0 vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = fightRequest.id;
        vo_19959_0.action = fightRequest.action;
        vo_19959_0.vid = fightRequest.vid;
        vo_19959_0.para = fightRequest.para;
        FightManager.send(fightContainer, new MSG_C_ACTION(), vo_19959_0);
        Vo_19945_0 vo_19945_0 = new Vo_19945_0();
        vo_19945_0.id = fightRequest.vid;
        vo_19945_0.hid = fightRequest.id;
        vo_19945_0.para_ex = 0;
        vo_19945_0.missed = 1;
        vo_19945_0.para = 0;
        vo_19945_0.damage_type = 2;
        FightManager.send(fightContainer, new MSG_C_ACCEPT_HIT(), vo_19945_0);
        Vo_64989_0 vo_64989_0 = new Vo_64989_0();
        vo_64989_0.hid = fightRequest.id;
        vo_64989_0.a = 2;
        List<FightObject> targetList = FightManager.findTarget(fightContainer, fightRequest, 1, jiNeng.range);
        Iterator var10 = targetList.iterator();

        while(var10.hasNext()) {
            FightObject fightObject = (FightObject)var10.next();
            vo_64989_0.list.add(fightObject.fid);
        }

        FightManager.send(fightContainer, new MSG_C_ACCEPT_MAGIC_HIT(), vo_64989_0);
        vo_19959_0 = new Vo_19959_0();
        vo_19959_0.round = fightContainer.round;
        vo_19959_0.aid = 0;
        vo_19959_0.action = 0;
        vo_19959_0.vid = 0;
        vo_19959_0.para = 0;
        FightManager.send(fightContainer, new MSG_C_ACTION(), vo_19959_0);
        Vo_7655_0 vo_7655_0 = new Vo_7655_0();
        vo_7655_0.id = 0;
        FightManager.send(fightContainer, new MSG_C_END_ACTION(), vo_7655_0);

        ZhangAiJin21Skill that;
        for(Iterator var15 = targetList.iterator(); var15.hasNext(); that.removeRound = fightContainer.round + jiNeng.skillRound - 1) {
            FightObject fightObject = (FightObject)var15.next();
            vo_19959_0 = new Vo_19959_0();
            vo_19959_0.round = fightContainer.round;
            vo_19959_0.aid = fightObject.fid;
            vo_19959_0.action = 43;
            vo_19959_0.vid = fightObject.fid;
            vo_19959_0.para = 0;
            FightManager.send(fightContainer, new MSG_C_ACTION(), vo_19959_0);
            vo_7655_0 = new Vo_7655_0();
            vo_7655_0.id = fightObject.fid;
            FightManager.send(fightContainer, new MSG_C_END_ACTION(), vo_7655_0);
            fightObject.addBuffState(fightContainer, this.getStateType());
            that = new ZhangAiJin21Skill();
            fightObject.addSkill(that);
            that.buffObject = fightObject;
        }

        return null;
    }

    protected void doRoundSkill() {
    }

    protected void doDisappear() {
    }

    public int getStateType() {
        return 3848;
    }
}
