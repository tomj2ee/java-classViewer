package com.nts.jvm.op;

public class Astore_1 extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x4c;
    }

    @Override
    String text() {
        return "astore_2";
    }
}
