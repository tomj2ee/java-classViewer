package com.nts.jvm.op;

public class Idc extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x12;
    }

    @Override
    String text() {
        return "idc";
    }
}
