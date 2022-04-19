package com.nts.jvm.op;

/**
* $跳转至指定 32 位地址偏移量位置，并将 jsr_w 下一条指令地址压入栈顶。
*
*/
public class Jsr_w  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xc9;
    }

    @Override
    String text() {
        return "jsr_w";
    }
}