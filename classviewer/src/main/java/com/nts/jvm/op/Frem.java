package com.nts.jvm.op;

/**
* $将栈顶两 float 型数值作取模运算并将结果压入栈顶。
*
*/
public class Frem  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x72;
    }

    @Override
    String text() {
        return "frem";
    }
}