package com.nts.jvm.op;

public class Invokeinterface  extends  Instruction{
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i=i+4;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xb9;
    }

    @Override
    String text() {
        return "invokeinterface";
    }
}
