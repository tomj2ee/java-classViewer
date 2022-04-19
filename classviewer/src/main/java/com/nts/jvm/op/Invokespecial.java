package com.nts.jvm.op;

public class Invokespecial  extends Instruction {

    int fieldIndex=0;
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        fieldIndex = getByte2(code,i);
        i=i+2;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xb7;
    }

    public int getIndex(){
        return fieldIndex;
    }

    @Override
    String text() {
        return "invokespecial";
    }
}
