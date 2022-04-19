package com.nts.jvm.op;

public class Iconst_0  extends Instruction {
    @Override
    public int read(byte[] code,int pc) {
        int i=pc;
        i++;
        return  i;
    }

    @Override
    int id() {
        return 0x03;
    }

    @Override
    String text() {
        return "iconst_0";
    }
}
