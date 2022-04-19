package com.nts.jvm.op;

/**
* $将栈顶 long 型数值存入指定局部变量。
*
*/
public class Lstore  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x37;
    }

    @Override
    String text() {
        return "lstore";
    }
}