package com.nts.jvm.op;

/**
* $从当前方法返回 long。
*
*/
public class Lreturn  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xad;
    }

    @Override
    String text() {
        return "lreturn";
    }
}