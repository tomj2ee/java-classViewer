package com.nts.jvm.op;

import com.nts.jvm.util.ByteUtils;

public class Iinc extends Instruction {
    private  int filedIndex;
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
        return 0x84;
    }
    public int getIndex(){
        return  filedIndex;
    }

    @Override
    String text() {
        return "iinc";
    }
}
