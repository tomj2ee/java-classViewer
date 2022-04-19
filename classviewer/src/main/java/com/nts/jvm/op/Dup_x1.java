package com.nts.jvm.op;

/**
* $复制栈顶数值并将两个复制值压入栈顶。
*
*/
public class Dup_x1  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x5a;
    }

    @Override
    String text() {
        return "dup_x1";
    }
}