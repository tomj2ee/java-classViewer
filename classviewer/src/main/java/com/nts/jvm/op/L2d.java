package com.nts.jvm.op;

/**
* $将栈顶 long 型数值强制转换成 double 型数值并将结果压入栈顶。
*
*/
public class L2d  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x8a;
    }

    @Override
    String text() {
        return "l2d";
    }
}