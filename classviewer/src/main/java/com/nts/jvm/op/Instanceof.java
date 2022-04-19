package com.nts.jvm.op;

/**
* $检验对象是否是指定的类的实例，如果是将 1 压入栈顶，否则将0 压入栈顶
*
*/
public class Instanceof  extends Instruction {
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        i=i+2;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xc1;
    }

    @Override
    String text() {
        return "instanceof";
    }
}