package com.nts.jvm.op;

/**
* $将栈顶 float 型数值存入第二个局部变量。
*
*/
public class Fstore_1  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x44;
    }

    @Override
    String text() {
        return "fstore_1";
    }
}