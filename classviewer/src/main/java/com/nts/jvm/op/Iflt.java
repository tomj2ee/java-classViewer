package com.nts.jvm.op;

import com.nts.jvm.util.ByteUtils;

/**
* $当栈顶 int 型数值小于 0 时跳转。
*
*/
public class Iflt  extends Instruction {
    private  int filedIndex;
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        filedIndex = getByte2(code,i);
        i=i+2;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0x9b;
    }
    public int getIndex(){
        return  filedIndex;
    }

    @Override
    String text() {
        return "iflt";
    }
}