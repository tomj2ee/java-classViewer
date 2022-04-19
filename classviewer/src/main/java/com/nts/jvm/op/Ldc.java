package com.nts.jvm.op;

/**
* $将 int，float 或 String 型常量值从常量池中推送至栈顶。
*
*/
public class Ldc  extends Instruction {

    private  int filedIndex;

    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        filedIndex=getByte1(code,i);
        i++;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x12;
    }
    public int getIndex(){
        return  filedIndex;
    }

    @Override
    String text() {
        return "ldc";
    }
}