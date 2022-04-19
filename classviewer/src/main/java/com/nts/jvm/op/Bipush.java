package com.nts.jvm.op;

public class Bipush extends Instruction {
    private byte b = ' ';

    @Override
    public  int read(byte[] code, int pc) {
        int i = pc;
        i++;
        b = code[i];
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x10;
    }

    @Override
    String text() {
        return "bipush " + b;
    }
}
