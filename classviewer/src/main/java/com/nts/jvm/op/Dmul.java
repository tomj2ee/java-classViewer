package com.nts.jvm.op;

/**
* $将栈顶两 double 型数值相乘并将结果压入栈顶。
*
*/
public class Dmul  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x6b;
    }

    @Override
    String text() {
        return "dmul";
    }
}