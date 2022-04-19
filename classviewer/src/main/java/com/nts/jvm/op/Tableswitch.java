package com.nts.jvm.op;

import com.nts.jvm.util.ByteUtils;

/**
* $用于 switch 条件跳转，case 值连续（可变长度指令）。
*
 *
*/
public class Tableswitch  extends Instruction {
    int def=0;
    int low=0;
    int high=0;
    StringBuilder sb=new StringBuilder();
    /**
     * tableswitch
     * <0-3 byte pad>
     * defaultbyte1
     * defaultbyte2
     * defaultbyte3
     * defaultbyte4
     * lowbyte1
     * lowbyte2
     * lowbyte3
     * lowbyte4
     *
     * highbyte1
     * highbyte2
     * highbyte3
     * highbyte4
     * jump offsets…
     *
     * @param code
     * @param pc
     * @return
     */
    @Override
    public int read(byte[] code, int pc) {
        int i=pc;
        int offset=4-i%4;
        for(int q=0;q<offset;q++){
            i=i+1;
        }

        byte[] dfByte = {code[i ], code[i + 1], code[i + 2], code[i + 3]};
        def = ByteUtils.getInt4(dfByte);
        i=i+4;

        byte lowByte[] = {code[i ], code[i + 1], code[i + 2], code[i + 3]};
        low = ByteUtils.getInt4(lowByte);
        i=i+4;

        byte highByte[] = {code[i ], code[i + 1], code[i + 2], code[i + 3]};
        high = ByteUtils.getInt4(highByte);
        i=i+4;
        int sz=high-low;
        for(int q=low;q<=high;q++) {
            byte itemByte[] = {code[i ], code[i + 1], code[i + 2], code[i + 3]};
            int off=ByteUtils.getInt4(itemByte);
            sb.append("\t\t"+ q +":"+  (pc+off)+ "(+"+off +")\n");
            i=i+4;
        }
        sb.append("\t\tdefault:"+  (pc+def) +"(+"+ def +")\n");
        return i;
    }

    @Override
    int id() {
        return 0xaa;
    }

    @Override
    String text() {
        return "tableswitch " +low+" to " + high +"\n"
                +sb.toString();
    }
}