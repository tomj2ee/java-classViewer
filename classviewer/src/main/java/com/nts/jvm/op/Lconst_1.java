package com.nts.jvm.op;

public class Lconst_1 extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x0a;
    }

    @Override
    String text() {
        return "lconst_1";
    }
}
