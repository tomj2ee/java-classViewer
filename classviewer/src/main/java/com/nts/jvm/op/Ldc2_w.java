package com.nts.jvm.op;

/**
* $将 long 或 double 型常量值从常量池中推送至栈顶（宽索引）。
*
*/
public class Ldc2_w  extends Instruction {
    private int filedIndex;

    @Override
    public  int read(byte[] code, int pc) {
        int i = pc;
        filedIndex = getByte2(code, i);
        i = i + 2;
        i++;
        return i;
    }

    public int getIndex() {
        return filedIndex;
    }

    @Override
    int id() {
        return 0x14;
    }

    @Override
    String text() {
        return "ldc2_w";
    }
}