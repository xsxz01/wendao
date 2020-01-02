package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45381_0;
import org.linlinjava.litemall.gameserver.data.write.M45381_0;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;


@Service
public class C45384_0
        implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        Vo_45381_0 vo_45381_0 = new Vo_45381_0();
        vo_45381_0.start_time = 1566766800;
        vo_45381_0.end_time = 1567371599;
        vo_45381_0.all_rewards_count = 36;
        vo_45381_0.no0 = 1;
        vo_45381_0.name0 = "墨麒麟";
        vo_45381_0.desc0 = "#I宠物|墨麒麟(精怪)$1$0#I";
        vo_45381_0.level0 = 0;
        vo_45381_0.no1 = 2;
        vo_45381_0.name1 = "九尾狐";
        vo_45381_0.desc1 = "#I宠物|九尾狐(神兽)$1$0#I";
        vo_45381_0.level1 = 0;
        vo_45381_0.no2 = 3;
        vo_45381_0.name2 = "白矖";
        vo_45381_0.desc2 = "#I宠物|白矖(神兽)$1$0#I";
        vo_45381_0.level2 = 0;
        vo_45381_0.no3 = 4;
        vo_45381_0.name3 = "疆良";
        vo_45381_0.desc3 = "#I宠物|疆良(神兽)$1$0#I";
        vo_45381_0.level3 = 0;
        vo_45381_0.no4 = 5;
        vo_45381_0.name4 = "玄武";
        vo_45381_0.desc4 = "#I宠物|玄武(神兽)$1$0#I";
        vo_45381_0.level4 = 0;
        vo_45381_0.no5 = 6;
        vo_45381_0.name5 = "朱雀";
        vo_45381_0.desc5 = "#I宠物|朱雀(神兽)$1$0#I";
        vo_45381_0.level5 = 0;
        vo_45381_0.no6 = 7;
        vo_45381_0.name6 = "东山神灵";
        vo_45381_0.desc6 = "#I宠物|东山神灵(神兽)$1$0#I";
        vo_45381_0.level6 = 0;
        vo_45381_0.no7 = 4;
        vo_45381_0.name7 = "帅帅猴";
        vo_45381_0.desc7 = "#I宠物|帅帅猴(变异)$1$0#I";
        vo_45381_0.level7 = 1;
        vo_45381_0.no8 = 5;
        vo_45381_0.name8 = "蛋蛋鸡";
        vo_45381_0.desc8 = "#I宠物|蛋蛋鸡(变异)$1$0#I";
        vo_45381_0.level8 = 1;
        vo_45381_0.no9 = 6;
        vo_45381_0.name9 = "乖乖狗";
        vo_45381_0.desc9 = "#I宠物|乖乖狗(变异)$1$0#I";
        vo_45381_0.level9 = 1;
        vo_45381_0.no10 = 7;
        vo_45381_0.name10 = "招财猪";
        vo_45381_0.desc10 = "#I宠物|招财猪(变异)$1$0#I";
        vo_45381_0.level10 = 1;
        vo_45381_0.no11 = 8;
        vo_45381_0.name11 = "岳麓剑";
        vo_45381_0.desc11 = "#I宠物|岳麓剑(精怪)$1$0#I";
        vo_45381_0.level11 = 1;
        vo_45381_0.no12 = 9;
        vo_45381_0.name12 = "筋斗云";
        vo_45381_0.desc12 = "#I宠物|筋斗云(精怪)$1$0#I";
        vo_45381_0.level12 = 1;
        vo_45381_0.no13 = 10;
        vo_45381_0.name13 = "神龙罩秘笈";
        vo_45381_0.desc13 = "#I物品|神龙罩秘笈#r1#I";
        vo_45381_0.level13 = 2;
        vo_45381_0.no14 = 11;
        vo_45381_0.name14 = "漫天血舞秘笈";
        vo_45381_0.desc14 = "#I物品|漫天血舞秘笈#r1#I";
        vo_45381_0.level14 = 2;
        vo_45381_0.no15 = 12;
        vo_45381_0.name15 = "舍命一击秘笈";
        vo_45381_0.desc15 = "#I物品|舍命一击秘笈#r1#I";
        vo_45381_0.level15 = 2;
        vo_45381_0.no16 = 13;
        vo_45381_0.name16 = "召唤令·上古神兽";
        vo_45381_0.desc16 = "#I物品|召唤令·上古神兽#r1#I";
        vo_45381_0.level16 = 2;
        vo_45381_0.no17 = 14;
        vo_45381_0.name17 = "召唤令·十二生肖";
        vo_45381_0.desc17 = "#I物品|召唤令·十二生肖#r1#I";
        vo_45381_0.level17 = 2;
        vo_45381_0.no18 = 12;
        vo_45381_0.name18 = "超级绿水晶";
        vo_45381_0.desc18 = "#I物品|超级绿水晶#r1#I";
        vo_45381_0.level18 = 3;
        vo_45381_0.no19 = 14;
        vo_45381_0.name19 = "黄水晶";
        vo_45381_0.desc19 = "#I物品|黄水晶#r1#I";
        vo_45381_0.level19 = 3;
        vo_45381_0.no20 = 15;
        vo_45381_0.name20 = "超级女娲石";
        vo_45381_0.desc20 = "#I物品|超级女娲石#r1#I";
        vo_45381_0.level20 = 3;
        vo_45381_0.no21 = 16;
        vo_45381_0.name21 = "高级驯兽诀";
        vo_45381_0.desc21 = "#I物品|高级驯兽诀#r1#I";
        vo_45381_0.level21 = 3;
        vo_45381_0.no22 = 17;
        vo_45381_0.name22 = "法玲珑";
        vo_45381_0.desc22 = "#I物品|法玲珑#r1#I";
        vo_45381_0.level22 = 3;
        vo_45381_0.no23 = 18;
        vo_45381_0.name23 = "羽化丹";
        vo_45381_0.desc23 = "#I物品|羽化丹#r1#I";
        vo_45381_0.level23 = 3;
        vo_45381_0.no24 = 19;
        vo_45381_0.name24 = "稀有满属性装备";
        vo_45381_0.desc24 = "#I装备|稀有满属性装备$color=(gold)#I";
        vo_45381_0.level24 = 3;
        vo_45381_0.no25 = 20;
        vo_45381_0.name25 = "神木鼎";
        vo_45381_0.desc25 = "#I物品|神木鼎#r1#I";
        vo_45381_0.level25 = 3;
        vo_45381_0.no26 = 21;
        vo_45381_0.name26 = "风灵丸";
        vo_45381_0.desc26 = "#I物品|风灵丸#r1#I";
        vo_45381_0.level26 = 3;
        vo_45381_0.no27 = 18;
        vo_45381_0.name27 = "超级归元露";
        vo_45381_0.desc27 = "#I物品|超级归元露#r1#I";
        vo_45381_0.level27 = 4;
        vo_45381_0.no28 = 20;
        vo_45381_0.name28 = "随机满属性装备";
        vo_45381_0.desc28 = "#I装备|随机满属性装备$color=(gold)#I";
        vo_45381_0.level28 = 4;
        vo_45381_0.no29 = 21;
        vo_45381_0.name29 = "50级首饰";
        vo_45381_0.desc29 = "#I首饰|50级首饰#I";
        vo_45381_0.level29 = 4;
        vo_45381_0.no30 = 22;
        vo_45381_0.name30 = "驯兽诀";
        vo_45381_0.desc30 = "#I物品|驯兽诀#r1#I";
        vo_45381_0.level30 = 4;
        vo_45381_0.no31 = 23;
        vo_45381_0.name31 = "超级仙风散";
        vo_45381_0.desc31 = "#I物品|超级仙风散#r1#I";
        vo_45381_0.level31 = 4;
        vo_45381_0.no32 = 24;
        vo_45381_0.name32 = "35级首饰";
        vo_45381_0.desc32 = "#I首饰|35级首饰#I";
        vo_45381_0.level32 = 4;
        vo_45381_0.no33 = 26;
        vo_45381_0.name33 = "灵池";
        vo_45381_0.desc33 = "#I物品|灵池#r1#I";
        vo_45381_0.level33 = 4;
        vo_45381_0.no34 = 27;
        vo_45381_0.name34 = "20级首饰";
        vo_45381_0.desc34 = "#I首饰|20级首饰#I";
        vo_45381_0.level34 = 4;
        vo_45381_0.no35 = 28;
        vo_45381_0.name35 = "血池";
        vo_45381_0.desc35 = "#I物品|血池#r1#I";
        vo_45381_0.level35 = 4;
        GameObjectChar.send(new M45381_0(), vo_45381_0);
    }


    public int cmd() {
        return 45384;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C45384_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */