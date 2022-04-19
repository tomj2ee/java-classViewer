package com.nts.jvm.op;

import com.nts.jvm.util.ByteUtils;

public class If_icmpge extends Instruction {
    int offset = 0;
    int to=0;

    @Override
    public  int read(byte[] code, int pc) {
        int i = pc;
        byte[] u2 = {code[i + 1], code[i + 2]};
        i += 2;
        offset = ByteUtils.getInt2(u2);
        to=pc+offset;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xa2;
    }

    @Override
    String text() {
        return "if_icmpge "  +to + "(+"+offset +")";
    }
}
