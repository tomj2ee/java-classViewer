package com.nts.jvm.op;

/**
* $将栈最顶端的两个数值互换（数值不能是 long 或 double 类型的）。
*
*/
public class Swap  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x5f;
    }

    @Override
    String text() {
        return "swap";
    }
}