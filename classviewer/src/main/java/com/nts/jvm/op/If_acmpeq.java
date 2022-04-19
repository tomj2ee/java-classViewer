package com.nts.jvm.op;

/**
* $比较栈顶两引用型数值，当结果相等时跳转。
*
*/
public class If_acmpeq  extends Instruction {
    private  int filedIndex=0;
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        filedIndex = getByte2(code,i);
        i=i+2;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xa5;
    }

    public int getIndex(){
        return  filedIndex;
    }

    @Override
    String text() {
        return "if_acmpeq";
    }
}