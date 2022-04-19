package com.nts.jvm.op;

/**
* $将栈顶 long 型数值存入第三个局部变量。
*
*/
public class Lstore_2  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x41;
    }

    @Override
    String text() {
        return "lstore_2";
    }
}