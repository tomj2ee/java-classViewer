package com.nts.jvm.op;

/**
* $将栈顶 double 型数值存入第二个局部变量。
*
*/
public class Dstore_1  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x48;
    }

    @Override
    String text() {
        return "dstore_1";
    }
}