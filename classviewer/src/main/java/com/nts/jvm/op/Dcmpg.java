package com.nts.jvm.op;

/**
* $比较栈顶两 double 型数值大小，并将结果（1，0，-1）压入栈顶；当其中一个数值为“NaN”时，将 1 压入栈顶。
*
*/
public class Dcmpg  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x98;
    }

    @Override
    String text() {
        return "dcmpg";
    }
}