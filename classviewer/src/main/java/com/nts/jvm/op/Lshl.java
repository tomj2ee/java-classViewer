package com.nts.jvm.op;

/**
* $将 long 型数值左移位指定位数并将结果压入栈顶。
*
*/
public class Lshl  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x79;
    }

    @Override
    String text() {
        return "lshl";
    }
}