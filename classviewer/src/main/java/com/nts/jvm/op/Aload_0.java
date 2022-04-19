package com.nts.jvm.op;

public class Aload_0  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x2a;
    }

    @Override
    String text() {
        return "aload_0";
    }
}
