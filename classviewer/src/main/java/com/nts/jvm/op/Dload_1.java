package com.nts.jvm.op;

/**
* $将第二个 double 型局部变量推送至栈顶。
*
*/
public class Dload_1  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x27;
    }

    @Override
    String text() {
        return "dload_1";
    }
}