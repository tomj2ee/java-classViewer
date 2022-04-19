package com.nts.jvm.op;

/**
* $将第三个 long 型局部变量推送至栈顶。
*
*/
public class Lload_2  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x20;
    }

    @Override
    String text() {
        return "lload_2";
    }
}