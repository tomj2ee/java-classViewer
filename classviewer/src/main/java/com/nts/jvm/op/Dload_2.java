package com.nts.jvm.op;

/**
* $将第三个 double 型局部变量推送至栈顶。
*
*/
public class Dload_2  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x28;
    }

    @Override
    String text() {
        return "dload_2";
    }
}