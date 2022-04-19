package com.nts.jvm.op;

/**
* $将栈顶 float 型数值存入第三个局部变量。
*
*/
public class Fstore_2  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x45;
    }

    @Override
    String text() {
        return "fstore_2";
    }
}