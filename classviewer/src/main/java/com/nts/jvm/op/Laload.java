package com.nts.jvm.op;

/**
* $将 long 型数组指定索引的值推送至栈顶。
*
*/
public class Laload  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x2f;
    }

    @Override
    String text() {
        return "laload";
    }
}