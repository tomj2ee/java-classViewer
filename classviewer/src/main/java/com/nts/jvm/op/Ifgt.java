package com.nts.jvm.op;

import com.nts.jvm.util.ByteUtils;

/**
* $当栈顶 int 型数值大于 0 时跳转。
*
*/
public class Ifgt  extends Instruction {

    private int filedIndex=0;
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
        return 0x9d;
    }

    public int getIndex(){
        return  filedIndex;
    }

    @Override
    String text() {
        return "ifgt";
    }
}