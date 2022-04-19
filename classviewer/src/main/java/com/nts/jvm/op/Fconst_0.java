package com.nts.jvm.op;

public class Fconst_0 extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x0b;
    }

    @Override
    String text() {
        return "fconst_0";
    }
}
