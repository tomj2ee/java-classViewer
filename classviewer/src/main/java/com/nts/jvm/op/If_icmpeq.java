package com.nts.jvm.op;

public class If_icmpeq  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i+=2;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x9f;
    }

    @Override
    String text() {
        return "if_icmpeq";
    }
}
