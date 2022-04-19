package com.nts.jvm.op;

/**
* $将栈顶两 float 型数值相除并将结果压入栈顶。
*
*/
public class Fdiv  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x6e;
    }

    @Override
    String text() {
        return "fdiv";
    }
}