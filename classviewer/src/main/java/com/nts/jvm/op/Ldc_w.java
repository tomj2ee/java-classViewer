package com.nts.jvm.op;

/**
* $将 int，float 或 String 型常量值从常量池中推送至栈顶（宽索引）。
*
*/
public class Ldc_w  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i=i+2;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x13;
    }

    @Override
    String text() {
        return "ldc_w";
    }
}