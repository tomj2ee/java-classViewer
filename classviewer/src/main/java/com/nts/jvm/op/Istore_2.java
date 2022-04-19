package com.nts.jvm.op;

public class Istore_2 extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x3d;
    }

    @Override
    String text() {
        return "istore_2";
    }
}
