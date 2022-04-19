package com.nts.jvm.op;

public class Aconst_null extends Instruction {
    @Override
    public  int read(byte[] code,int pc) {
        int i=pc;
        i++;
        return  i;
    }

    @Override
    int id() {
        return 0x01;
    }

    @Override
    String text() {
        return "aconst_null";
    }
}
