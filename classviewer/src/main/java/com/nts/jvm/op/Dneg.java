package com.nts.jvm.op;

/**
* $将栈顶 double 型数值取负并将结果压入栈顶。
*
*/
public class Dneg  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x77;
    }

    @Override
    String text() {
        return "dneg";
    }
}