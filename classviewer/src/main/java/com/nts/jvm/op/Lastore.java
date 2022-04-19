package com.nts.jvm.op;

/**
* $将栈顶 long 型数值存入指定数组的指定索引位置。
*
*/
public class Lastore  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x50;
    }

    @Override
    String text() {
        return "lastore";
    }
}