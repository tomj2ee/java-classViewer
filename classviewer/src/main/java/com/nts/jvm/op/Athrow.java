package com.nts.jvm.op;

/**
* $将栈顶的异常抛出。
*
*/
public class Athrow  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xbf;
    }

    @Override
    String text() {
        return "athrow";
    }
}