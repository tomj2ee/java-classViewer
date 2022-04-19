package com.nts.jvm.op;

/**
* $创建一个引用型（如类，接口，数组）的数组，并将其引用值压入栈顶。
*
*/
public class Anewarray  extends Instruction {
    private int filedIndex;

    @Override
    public int read(byte[] code, int pc) {
        int i = pc;
        filedIndex = getByte2(code, i);
        i = i + 2;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xbd;
    }

    public int getIndex() {
        return filedIndex;
    }


    @Override
    String text() {
        return "anewarray";
    }
}