package com.nts.jvm.op;

/**
* $将指定的 long 型局部变量推送至栈顶。
*
*/
public class Lload  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x16;
    }

    @Override
    String text() {
        return "lload";
    }
}