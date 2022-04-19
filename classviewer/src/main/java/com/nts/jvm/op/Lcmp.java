package com.nts.jvm.op;

/**
* $比较栈顶两 long 型数值大小，并将结果（1，0，-1）压入栈顶。
*
*/
public class Lcmp  extends Instruction {
    @Override
    public   int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x94;
    }

    @Override
    String text() {
        return "lcmp";
    }
}