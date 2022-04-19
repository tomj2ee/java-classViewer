package com.nts.jvm.op;


public class Ifnull extends Instruction {

    //Operation
    //Fetch field from object
    //
    //Format
    //
    //new
    //indexbyte1
    //indexbyte2
    //Forms
    //getfield = 180 (0xc6)
    //
    //Operand Stack
    //..., objectref →
    //
    //..., value

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
        return 0xbb;
    }

    public int getIndex(){
        return  filedIndex;
    }
    @Override
    String text() {
        return "ifnull";
    }
}
