package com.nts.jvm.op;

/**
* $用于在特定硬件中使用的语言后门。
*
*/
public class Impdep1  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xff;
    }

    @Override
    String text() {
        return "impdep1";
    }
}