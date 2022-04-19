package com.nts.jvm.op;

/**
* $将栈顶两 long 型数值作“按位与”并将结果压入栈顶。
*
*/
public class Land  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x7f;
    }

    @Override
    String text() {
        return "land";
    }
}