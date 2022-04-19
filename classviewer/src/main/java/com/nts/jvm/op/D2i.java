package com.nts.jvm.op;

/**
* $将栈顶 double 型数值强制转换成 int 型数值并将结果压入栈顶。
*
*/
public class D2i  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x8e;
    }

    @Override
    String text() {
        return "d2i";
    }
}