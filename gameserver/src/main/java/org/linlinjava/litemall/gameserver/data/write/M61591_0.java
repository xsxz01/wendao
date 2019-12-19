/*    */ package org.linlinjava.litemall.gameserver.data.write;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import org.linlinjava.litemall.gameserver.data.GameWriteTool;
/*    */ import org.linlinjava.litemall.gameserver.data.vo.Vo_61591_0;
/*    */ import org.linlinjava.litemall.gameserver.netty.BaseWrite;
/*    */ 
/*    */ @org.springframework.stereotype.Service
/*    */ public class M61591_0 extends BaseWrite
/*    */ {
/*    */   protected void writeO(ByteBuf writeBuf, Object object)
/*    */   {
/* 13 */     Vo_61591_0 object1 = (Vo_61591_0)object;
/* 14 */     GameWriteTool.writeString(writeBuf, object1.ask_type);
/*    */     
/* 16 */     GameWriteTool.writeShort(writeBuf, Integer.valueOf(1));
/*    */     
/* 18 */     GameWriteTool.writeString(writeBuf, object1.name);
/*    */   }
/*    */   
/*    */   public int cmd()
/*    */   {
/* 23 */     return 61591;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M61591_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */