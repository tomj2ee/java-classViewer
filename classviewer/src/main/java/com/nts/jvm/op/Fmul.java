package com.nts.jvm.op;

/**
* $将栈顶两 float 型数值相乘并将结果压入栈顶。
*
*/
public class Fmul  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x6a;
    }

    @Override
    String text() {
        return "fmul";
    }
}