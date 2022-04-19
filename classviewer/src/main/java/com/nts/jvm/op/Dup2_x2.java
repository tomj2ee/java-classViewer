package com.nts.jvm.op;

/**
* $dup_x2 指令的双倍版本。
*
*/
public class Dup2_x2  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x5e;
    }

    @Override
    String text() {
        return "dup2_x2";
    }
}