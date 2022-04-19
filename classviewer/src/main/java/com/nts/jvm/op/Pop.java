package com.nts.jvm.op;

public class Pop extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x57;
    }

    @Override
    String text() {
        return "pop";
    }
}
