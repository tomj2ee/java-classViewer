package com.nts.jvm.op;

public class Fconst_1 extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x0c;
    }

    @Override
    String text() {
        return "fconst_2";
    }
}
