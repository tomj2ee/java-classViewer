package com.nts.jvm.op;

public class Iconst_1  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x04;
    }

    @Override
    String text() {
        return "iconst_1";
    }
}
