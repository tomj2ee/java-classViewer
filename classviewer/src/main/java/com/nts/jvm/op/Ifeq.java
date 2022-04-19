package com.nts.jvm.op;

/**
* $当栈顶 int 型数值等于 0 时跳转。
*
*/
public class Ifeq  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i+=2;
        i=i+1;
        return i;
    }

    @Override
    int id() {
        return 0x99;
    }

    @Override
    String text() {
        return "ifeq";
    }
}