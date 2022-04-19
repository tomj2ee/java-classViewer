package com.nts.jvm.op;

public class Aload_2 extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x2c;
    }

    @Override
    String text() {
        return "aload_2";
    }
}
