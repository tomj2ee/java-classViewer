package com.nts.jvm.op;

public class Newarray extends Instruction {
    private  int filedIndex;
    @Override
    public  int read(byte[] code, int pc) {
        int i = pc;
        filedIndex = getByte1(code, i);
        i++;
        i++;
        return i;
    }


    @Override
    public int getIndex() {
        return  filedIndex;
    }
    @Override
    int id() {
        return 0xbc;
    }

    @Override
    String text() {
        return "newarray";
    }
}
