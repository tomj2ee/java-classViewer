package com.nts.jvm.op;

/**
* $跳转至指定 16 位 offset 位置，并将 jsr 下一条指令地址压入栈顶。
*
*/
public class Jsr  extends Instruction {
    @Override
    public   int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xa8;
    }

    @Override
    String text() {
        return "jsr";
    }
}