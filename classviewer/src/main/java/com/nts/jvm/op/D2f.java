package com.nts.jvm.op;

/**
* $将栈顶double型数值强制转换成float型数值并将结果压入栈顶。
*
*/
public class D2f  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x90;
    }

    @Override
    String text() {
        return "d2f";
    }
}