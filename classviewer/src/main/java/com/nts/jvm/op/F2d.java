package com.nts.jvm.op;

/**
* $将栈顶float型数值强制转换成double型数值并将结果压入栈顶。
*
*/
public class F2d  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x8d;
    }

    @Override
    String text() {
        return "f2d";
    }
}