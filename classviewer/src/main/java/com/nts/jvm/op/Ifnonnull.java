package com.nts.jvm.op;

/**
* $不为 null 时跳转。
*
*/
public class Ifnonnull  extends Instruction {
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
        return 0xc7;
    }
    public int getIndex(){
        return  filedIndex;
    }

    @Override
    String text() {
        return "ifnonnull";
    }
}