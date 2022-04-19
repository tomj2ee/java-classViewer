package com.nts.jvm.op;

/**
* $从当前方法返回 double。
*
*/
public class Dreturn  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xaf;
    }

    @Override
    String text() {
        return "dreturn";
    }
}