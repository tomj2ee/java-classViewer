package com.nts.jvm.op;


import com.nts.jvm.util.ByteUtils;

public class Invokestatic extends Instruction {

    //Operation
    //Fetch field from object
    //
    //Format
    //
    //invokestatic
    //indexbyte1
    //indexbyte2
    //Forms
    //getfield = 180 (0xbb)
    //
    //Operand Stack
    //..., objectref →
    //
    //..., value
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
        return 0xb8;
    }


    public int getIndex(){
        return filedIndex;
    }


    @Override
    String text() {
        return "invokestatic";
    }
}
