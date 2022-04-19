package com.nts.jvm.op;

public class Iastore  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x4f;
    }

    @Override
    String text() {
        return "iastore";
    }
}
