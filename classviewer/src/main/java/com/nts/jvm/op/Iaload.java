package com.nts.jvm.op;

/**
* $将 int 型数组指定索引的值推送至栈顶。
*
*/
public class Iaload  extends Instruction {
    @Override
    public   int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x2e;
    }

    @Override
    String text() {
        return "iaload";
    }
}