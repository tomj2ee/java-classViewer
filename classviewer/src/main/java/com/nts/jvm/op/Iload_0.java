package com.nts.jvm.op;

public class Iload_0 extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x1a;
    }

    @Override
    String text() {
        return "iload_0";
    }
}
