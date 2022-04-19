package com.nts.jvm.op;

/**
* $将栈顶 float 型数值取负并将结果压入栈顶。
*
*/
public class Fneg  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x76;
    }

    @Override
    String text() {
        return "fneg";
    }
}