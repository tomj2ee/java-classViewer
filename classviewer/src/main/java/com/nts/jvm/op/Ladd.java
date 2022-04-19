package com.nts.jvm.op;

/**
* $将栈顶两 long 型数值相加并将结果压入栈顶。
*
*/
public class Ladd  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x61;
    }

    @Override
    String text() {
        return "ladd";
    }
}