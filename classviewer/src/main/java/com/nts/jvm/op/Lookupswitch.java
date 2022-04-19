package com.nts.jvm.op;

import com.nts.jvm.util.ByteUtils;

/**
 * $用于 switch 条件跳转，case 值不连续（可变长度指令）。
 */
public class Lookupswitch extends Instruction {
    int def = 0;
    int paris = 0;
    StringBuilder sb = new StringBuilder();

    /**
     * lookupswitch
     * <0-3 byte pad>
     * defaultbyte1
     * defaultbyte2
     * defaultbyte3
     * defaultbyte4
     * npairs1
     * npairs2
     * npairs3
     * npairs4
     * match-offset pairs…
     */

    @Override
    public int read(byte[] code, int pc) {
        int i = pc;
        int offset = 4 - i %4;
        for (int q = 0; q < offset; q++) {
            i = i + 1;
        }

        byte[] dfByte = {code[i], code[i + 1], code[i + 2], code[i + 3]};
        def = ByteUtils.getInt4(dfByte);
        i += 4;
        byte[] npairs = {code[i], code[i + 1], code[i + 2], code[i + 3]};

        paris = ByteUtils.getInt4(npairs);
        i += 4;
        for (int q = 0; q < paris; q++) {
            byte[] code1 = {code[i], code[i + 1], code[i + 2], code[i + 3]};
            byte[] code2 = {code[i + 4], code[i + 5], code[i + 6], code[i + 7]};
            i = i + 8;
            int off = ByteUtils.getInt4(code2);
            sb.append("\t\t" + ByteUtils.getInt4(code1) + ":" + (pc + off) + "(+" + off + ")\n");
        }
        {
            sb.append("\t\tdefault:" + (pc + def) + "(+" + def + ")\n");

        }
        return i;
    }

    @Override
    int id() {
        return 0xab;
    }

    @Override
    String text() {
        return "lookupswitch " + def + "(\n " + sb.toString() + ")";
    }
}