package com.nts.jvm.op;

public class Iconst_4  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x07;
    }

    @Override
    String text() {
        return "iconst_4";
    }
}
