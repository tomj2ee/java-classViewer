package com.nts.jvm.op;

/**
* $将栈顶两 int 型数值作取模运算并将结果压入栈顶。
*
*/
public class Irem  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x70;
    }

    @Override
    String text() {
        return "irem";
    }
}