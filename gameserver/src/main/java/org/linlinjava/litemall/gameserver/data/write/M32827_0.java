/*    */ package org.linlinjava.litemall.gameserver.data.write;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import org.linlinjava.litemall.gameserver.data.GameWriteTool;
/*    */ import org.linlinjava.litemall.gameserver.data.vo.Vo_32827_0;
/*    */ 
/*    */ @org.springframework.stereotype.Service
/*    */ public class M32827_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite
/*    */ {
/*    */   protected void writeO(ByteBuf writeBuf, Object object)
/*    */   {
/* 12 */     Vo_32827_0 object1 = (Vo_32827_0)object;
/* 13 */     GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.has_pwd));
/*    */     
/* 15 */     GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isReleaseLock));
/*    */     
/* 17 */     GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.reset_start));
/*    */     
/* 19 */     GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.reset_end));
/*    */     
/* 21 */     GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.reset_days));
/*    */   }
/*    */   
/* 24 */   public int cmd() { return 32827; }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M32827_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */