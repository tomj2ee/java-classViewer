package com.nts.jvm.op;

/**
* $将指定的 double 型局部变量推送至栈顶。
*
*/
public class Dload  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x18;
    }

    @Override
    String text() {
        return "dload";
    }
}