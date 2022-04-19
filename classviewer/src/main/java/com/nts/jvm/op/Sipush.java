package com.nts.jvm.op;

import com.nts.jvm.util.ByteUtils;

public class Sipush extends Instruction {
    private int b = 0;

    @Override
    public  int read(byte[] code, int pc) {
        int i = pc;
        byte[] bytes = {code[i + 1], code[i + 2]};
        b = ByteUtils.getInt2(bytes);
        i = i + 2;

        i++;
        return i;
    }

    @Override
    int id() {
        return 0x11;
    }

    @Override
    String text() {
        return "sipush " + b;
    }
}
