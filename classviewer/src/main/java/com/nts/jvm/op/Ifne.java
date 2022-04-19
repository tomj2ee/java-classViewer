package com.nts.jvm.op;

/**
* $当栈顶 int 型数值不等于 0 时跳转。
*
*/
public class Ifne  extends Instruction {
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
        return 0x9a;
    }
    public int getIndex(){
        return  filedIndex;
    }

    @Override
    String text() {
        return "ifne";
    }
}