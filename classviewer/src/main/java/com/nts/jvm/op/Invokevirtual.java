package com.nts.jvm.op;

import com.nts.jvm.util.ByteUtils;

public class Invokevirtual extends Instruction {
    private  int filedIndex=0;
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        byte[] bytes = {code[i+1], code[i + 2]};
        filedIndex = ByteUtils.getInt2(bytes);
        i=i+2;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xb6;
    }

    public int getIndex(){
        return filedIndex;
    }

    @Override
    String text() {
        return "invokevirtual\t"  + " #"+filedIndex ;
    }
}
