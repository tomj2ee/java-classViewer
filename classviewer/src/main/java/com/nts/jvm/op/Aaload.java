package com.nts.jvm.op;

/**
* $将引用型数组指定索引的值推送至栈顶。
*
*/
public class Aaload  extends Instruction {
    @Override
   public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x32;
    }

    @Override
    String text() {
        return "aaload";
    }
}