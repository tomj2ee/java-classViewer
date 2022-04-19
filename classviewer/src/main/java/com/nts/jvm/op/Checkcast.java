package com.nts.jvm.op;


public class Checkcast extends Instruction {

    //Operation
    //Fetch field from object
    //
    //Format
    //
    //checkcast
    //indexbyte1
    //indexbyte2
    //Forms
    //getfield = 180 (0xc6)
    //
    //Operand Stack
    //..., objectref →
    //
    //..., value
    private  int filedIndex=0;
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
        return 0xc0;
    }

     public int getIndex(){
        return filedIndex;
    }

    @Override
    String text() {
        return "checkcast";
    }
}
