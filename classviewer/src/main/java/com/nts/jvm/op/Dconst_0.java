package com.nts.jvm.op;

public class Dconst_0 extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x0e;
    }

    @Override
    String text() {
        return "dconst_0";
    }
}
