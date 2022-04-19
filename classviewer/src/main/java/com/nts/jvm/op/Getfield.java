package com.nts.jvm.op;


import com.nts.jvm.util.ByteUtils;

import java.io.FileInputStream;

public class Getfield  extends Instruction {

    //Operation
    //Fetch field from object
    //
    //Format
    //
    //getfield
    //indexbyte1
    //indexbyte2
    //Forms
    //getfield = 180 (0xb4)
    //
    //Operand Stack
    //..., objectref →
    //
    //..., value

    private int filedIndex = 0;

    @Override
    public int read(byte[] code, int pc) {
        int i = pc;
        byte[] bytes = {code[i+1], code[i + 2]};
        filedIndex = ByteUtils.getInt2(bytes);
        i = i + 2;
        i++;
        return i;
    }

    @Override
    int id() {
        return 0xb4;
    }
    public int getIndex(){
        return filedIndex;
    }


    @Override
    String text() {
        return "getfield\t" + " #"+filedIndex ;
    }
}
