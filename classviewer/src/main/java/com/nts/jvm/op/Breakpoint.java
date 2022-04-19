package com.nts.jvm.op;

/**
* $调试时的断点标志。
*
*/
public class Breakpoint  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xca;
    }

    @Override
    String text() {
        return "breakpoint";
    }
}