package com.nts.jvm.op;

public class Astore extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x3a;
    }

    @Override
    String text() {
        return "astore";
    }
}
