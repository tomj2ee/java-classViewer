package com.nts.jvm.op;

/**
* $扩展访问局部变量表的索引宽度。
*
*/
public class Wide  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xc4;
    }

    @Override
    String text() {
        return "wide";
    }
}