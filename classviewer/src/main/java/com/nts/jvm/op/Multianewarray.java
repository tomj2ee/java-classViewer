package com.nts.jvm.op;

/**
* $创建指定类型和指定维度的多维数组（执行该指令时，操作栈中必须包含各维度的长度值），并将其引用值压入栈顶。
*
*/
public class Multianewarray  extends Instruction {
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xc5;
    }

    @Override
    String text() {
        return "multianewarray";
    }
}