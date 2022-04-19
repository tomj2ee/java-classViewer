package com.nts.jvm.op;

/**
* $将第四个 float 型局部变量推送至栈顶。
*
*/
public class Fload_3  extends Instruction {
    @Override
    public   int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x25;
    }

    @Override
    String text() {
        return "fload_3";
    }
}