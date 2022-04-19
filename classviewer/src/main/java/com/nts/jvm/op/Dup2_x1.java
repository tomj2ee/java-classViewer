package com.nts.jvm.op;

/**
* $dup_x1 指令的双倍版本。
*
*/
public class Dup2_x1  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x5d;
    }

    @Override
    String text() {
        return "dup2_x1";
    }
}