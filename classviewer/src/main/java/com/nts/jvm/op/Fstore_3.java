package com.nts.jvm.op;

/**
* $将栈顶 float 型数值存入第四个局部变量。
*
*/
public class Fstore_3  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x46;
    }

    @Override
    String text() {
        return "fstore_3";
    }
}