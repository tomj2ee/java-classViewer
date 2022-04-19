package com.nts.jvm.op;

public class Nop  extends Instruction {

    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x00;
    }

    @Override
    String text() {
        return "NOP";
    }

    @Override
    public String toString() {
        return "NOP";
    }
}
