package com.nts.jvm.op;

public class Areturn extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xb0;
    }

    @Override
    String text() {
        return "areturn";
    }
}
