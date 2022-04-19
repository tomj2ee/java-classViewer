package com.nts.jvm.op;

/**
* $为指定的类的静态域赋值。
*
*/
public class Putstatic  extends Instruction {
    private  int filedIndex;
    @Override
    public  int read(byte[] code, int pc) {
        int i = pc;
        filedIndex = getByte2(code,i);
        i = i + 2;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xb3;
    }

    public int getIndex(){
        return  filedIndex;
    }

    @Override
    String text() {
        return "putstatic ";
    }
}