package com.nts.jvm.op;

/**
* $将栈顶 double 型数值存入指定局部变量。
*
*/
public class Dstore  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x39;
    }

    @Override
    String text() {
        return "dstore";
    }
}