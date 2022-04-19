package com.nts.jvm.op;

/**
* $将第三个 float 型局部变量推送至栈顶
*
*/
public class Fload_2  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x24;
    }

    @Override
    String text() {
        return "fload_2";
    }
}