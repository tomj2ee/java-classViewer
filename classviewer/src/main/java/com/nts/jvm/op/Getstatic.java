package com.nts.jvm.op;

public class Getstatic extends Instruction {
    private  int filedIndex=0;
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        filedIndex = getByte2(code,i);
        i=i+2;
        i=i+1;
        return i;
    }

    @Override
    int id() {
        return 0xb2;
    }

    public int getIndex(){
        return filedIndex;
    }

    @Override
    String text() {
        return "getstatic";
    }
}
