package com.nts.jvm.op;

public class Ireturn extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xac;
    }

    @Override
    String text() {
        return "ireturn";
    }
}
