/*    */ package org.linlinjava.litemall.gameserver.data.write;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import org.linlinjava.litemall.gameserver.data.GameWriteTool;
/*    */ import org.linlinjava.litemall.gameserver.data.vo.Vo_20912_0;
/*    */ 
/*    */ @org.springframework.stereotype.Service
/*    */ public class M20912_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite
/*    */ {
/*    */   protected void writeO(ByteBuf writeBuf, Object object)
/*    */   {
/* 12 */     Vo_20912_0 object1 = (Vo_20912_0)object;
/* 13 */     GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.flag));
/*    */     
/* 15 */     GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.open_time));
/*    */   }
/*    */   
/* 18 */   public int cmd() { return 20912; }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M20912_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */