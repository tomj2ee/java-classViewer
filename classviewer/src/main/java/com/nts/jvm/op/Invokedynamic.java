package com.nts.jvm.op;

/**
* $调用动态链接方法①。
*
*/
public class Invokedynamic  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xba;
    }

    @Override
    String text() {
        return "invokedynamic";
    }
}