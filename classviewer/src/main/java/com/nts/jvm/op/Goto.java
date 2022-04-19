package com.nts.jvm.op;

public class Goto extends Instruction {
    private  int filedIndex=0;
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        filedIndex = getByte2(code,i);
        i=i+2;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xa7;
    }

    @Override
    String text() {
        return "goto\t#" + filedIndex;
    }
}
