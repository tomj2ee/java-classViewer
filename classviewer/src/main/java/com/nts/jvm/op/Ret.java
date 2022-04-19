package com.nts.jvm.op;

/**
* $返回至局部变量指定的 index 的指令位置（一般与 jsr，jsr_w联合使用）。
*
*/
public class Ret  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xa9;
    }

    @Override
    String text() {
        return "ret";
    }
}