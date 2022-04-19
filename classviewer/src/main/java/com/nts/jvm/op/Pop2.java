package com.nts.jvm.op;

public class Pop2 extends Instruction {
    @Override
    public   int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x58;
    }

    @Override
    String text() {
        return "pop2";
    }
}
