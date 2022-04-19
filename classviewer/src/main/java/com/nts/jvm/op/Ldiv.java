package com.nts.jvm.op;

/**
* $将栈顶两 long 型数值相除并将结果压入栈顶。
*
*/
public class Ldiv  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x6d;
    }

    @Override
    String text() {
        return "ldiv";
    }
}