package com.nts.jvm.op;

/**
* $将栈顶 int 型数值强制转换成 short 型数值并将结果压入栈顶。
*
*/
public class I2s  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x93;
    }

    @Override
    String text() {
        return "i2s";
    }
}