package com.nts.jvm.op;

/**
* $将第四个 long 型局部变量推送至栈顶。
*
*/
public class Lload_3  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x21;
    }

    @Override
    String text() {
        return "lload_3";
    }
}