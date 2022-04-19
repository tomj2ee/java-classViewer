package com.nts.jvm.op;

/**
* $将栈顶 float 型数值强制转换成 long 型数值并将结果压入栈顶。
*
*/
public class F2l  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x8c;
    }

    @Override
    String text() {
        return "f2l";
    }
}