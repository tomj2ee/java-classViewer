package com.nts.jvm.op;

/**
* $将栈顶两 int 型数值相减并将结果压入栈顶。
*
*/
public class Isub  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x64;
    }

    @Override
    String text() {
        return "isub";
    }
}