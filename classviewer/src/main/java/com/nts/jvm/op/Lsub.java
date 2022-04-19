package com.nts.jvm.op;

/**
* $将栈顶两 long 型数值相减并将结果压入栈顶。
*
*/
public class Lsub  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x65;
    }

    @Override
    String text() {
        return "lsub";
    }
}