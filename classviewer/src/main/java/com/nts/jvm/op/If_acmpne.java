package com.nts.jvm.op;

/**
* $比较栈顶两引用型数值，当结果不相等时跳转。
*
*/
public class If_acmpne  extends Instruction {
    private  int filedIndex;
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
        return 0xa6;
    }
    public int getIndex(){
        return  filedIndex;
    }

    @Override
    String text() {
        return "if_acmpne";
    }
}