package com.nts.jvm.buff;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class PcBufferInputStream  extends BufferedInputStream {

    public PcBufferInputStream(InputStream in) {
        super(in);
    }

    public int getPc() {
        return pos;
    }
}
