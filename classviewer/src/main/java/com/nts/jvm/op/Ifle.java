package com.nts.jvm.op;

/**
* $当栈顶 int 型数值小于等于 0 时跳转。
*
*/
public class Ifle  extends Instruction {

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
        return 0x9e;
    }
    public int getIndex(){
        return  filedIndex;
    }

    @Override
    String text() {
        return "ifle";
    }
}