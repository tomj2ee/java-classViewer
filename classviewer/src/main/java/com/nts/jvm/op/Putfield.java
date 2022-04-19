package com.nts.jvm.op;


public class Putfield extends Instruction {

    //Operation
    //Fetch field from object
    //
    //Format
    //
    //putfield
    //indexbyte1
    //indexbyte2
    //Forms
    //getfield = 180 (0xb4)
    //
    //Operand Stack
    //..., objectref →
    //
    //..., value
    @Override
    public  int read(byte[] code, int pc) {
        int i=pc;
        i=i+2;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xb5;
    }

    @Override
    String text() {
        return "getfield";
    }
}
