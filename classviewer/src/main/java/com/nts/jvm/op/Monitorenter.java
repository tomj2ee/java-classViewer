package com.nts.jvm.op;

/**
* $获得对象的 monitor，用于同步方法或同步块。
*
*/
public class Monitorenter  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xc2;
    }

    @Override
    String text() {
        return "monitorenter";
    }
}