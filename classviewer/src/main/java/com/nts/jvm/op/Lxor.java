package com.nts.jvm.op;

/**
* $将栈顶两 long 型数值作“按位异或”并将结果压入栈顶。
*
*/
public class Lxor  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x83;
    }

    @Override
    String text() {
        return "lxor";
    }
}