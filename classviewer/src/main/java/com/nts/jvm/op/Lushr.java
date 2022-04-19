package com.nts.jvm.op;

/**
* $将 long 型数值右（无符号）移位指定位数并将结果压入栈顶。
*
*/
public class Lushr  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x7d;
    }

    @Override
    String text() {
        return "lushr";
    }
}