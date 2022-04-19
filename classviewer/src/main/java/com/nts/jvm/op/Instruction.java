package com.nts.jvm.op;

import com.nts.jvm.util.ByteUtils;

public abstract class Instruction {


    public abstract int read(byte[] code, int pc);

    private byte[] code;

    abstract int id();

    abstract String text();

    @Override
    public String toString() {
        return text();
    }

    public int getIndex() {
        return 0;
    }


    protected int getByte2(byte[] code, int pc) {
        byte[] bytes = {code[pc + 1], code[pc + 2]};
        return ByteUtils.getInt2(bytes);
    }

    protected int getByte1(byte[] code, int pc) {
        byte[] bytes = {code[pc + 1]};
        return ByteUtils.getInt1(bytes);
    }


}
