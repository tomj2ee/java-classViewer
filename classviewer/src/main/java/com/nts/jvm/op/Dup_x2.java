package com.nts.jvm.op;

/**
* $复制栈顶数值并将三个（或两个）复制值压入栈顶。
*
*/
public class Dup_x2  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x5b;
    }

    @Override
    String text() {
        return "dup_x2";
    }
}