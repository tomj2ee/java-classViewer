package com.nts.jvm.op;

public class Istore_3 extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x3e;
    }

    @Override
    String text() {
        return "istore_3";
    }
}
