package com.nts.jvm.op;

/**
* $将 float 型数组指定索引的值推送至栈顶。
*
*/
public class Faload  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x30;
    }

    @Override
    String text() {
        return "faload";
    }
}