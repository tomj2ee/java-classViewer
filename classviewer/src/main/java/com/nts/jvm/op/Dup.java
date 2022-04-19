package com.nts.jvm.op;

public class Dup extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x59;
    }

    @Override
    String text() {
        return "dup";
    }
}
