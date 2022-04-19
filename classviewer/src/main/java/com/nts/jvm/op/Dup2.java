package com.nts.jvm.op;

/**
* $复制栈顶一个（long 或 double 类型的)或两个（其它）数值并
*
*/
public class Dup2  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x5c;
    }

    @Override
    String text() {
        return "dup2";
    }
}