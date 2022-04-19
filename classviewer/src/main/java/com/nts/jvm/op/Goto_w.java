package com.nts.jvm.op;

public class Goto_w extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i=i+4;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xc8;
    }

    @Override
    String text() {
        return "goto_w";
    }
}
