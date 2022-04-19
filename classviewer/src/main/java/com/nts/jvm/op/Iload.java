package com.nts.jvm.op;

public class Iload extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x15;
    }

    @Override
    String text() {
        return "iload";
    }
}
