package com.nts.jvm.op;

import com.nts.jvm.util.ByteUtils;

/**
* $当栈顶 int 型数值大于等于 0 时跳转。
*
*/
public class Ifge  extends Instruction {

    private int filedIndex;
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        filedIndex=getByte1(code,i);
        i=i+2;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x9c;
    }
    public int getIndex(){
        return  filedIndex;
    }

    @Override
    String text() {
        return "ifge";
    }
}