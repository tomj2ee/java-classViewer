package com.nts.jvm.op;

/**
* $将栈顶 float 型数值强制转换成 int 型数值并将结果压入栈顶。
*
*/
public class F2i  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x8b;
    }

    @Override
    String text() {
        return "f2i";
    }
}