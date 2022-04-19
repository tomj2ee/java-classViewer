package com.nts.jvm.op;

/**
* $将第二个 float 型局部变量推送至栈顶。
*
*/
public class Fload_1  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x23;
    }

    @Override
    String text() {
        return "fload_1";
    }
}