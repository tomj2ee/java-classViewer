package com.nts.jvm.op;

public class Aload_3 extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x2d;
    }

    @Override
    String text() {
        return "aload_3";
    }
}
