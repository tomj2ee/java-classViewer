package com.nts.jvm.op;

/**
* $从当前方法返回 float。
*
*/
public class Freturn  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xae;
    }

    @Override
    String text() {
        return "freturn";
    }
}