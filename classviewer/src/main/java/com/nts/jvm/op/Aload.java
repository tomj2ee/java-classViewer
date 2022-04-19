package com.nts.jvm.op;

public class Aload extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i=i+1;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x19;
    }

    @Override
    String text() {
        return "aload";
    }
}
