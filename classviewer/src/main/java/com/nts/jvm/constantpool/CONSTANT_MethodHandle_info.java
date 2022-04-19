package com.nts.jvm.constantpool;

import com.nts.jvm.util.ByteUtils;

import java.util.ArrayList;

public class CONSTANT_MethodHandle_info extends CP_info {


    public int getTag() {

        return 15;

    }

    @Override
    public void readContent() throws Exception {
        super.readContent();
        referenceKind = ByteUtils.getInt1(getContentList().get(0)) ;
        referenceIndex = ByteUtils.getInt2(getContentList().get(1)) ;
    }

    public int getReferenceKind() {
        return referenceKind;
    }

    public void setReferenceKind(int referenceKind) {
        this.referenceKind = referenceKind;
    }

    public int getReferenceIndex() {
        return referenceIndex;
    }

    public void setReferenceIndex(int referenceIndex) {
        this.referenceIndex = referenceIndex;
    }

    private int referenceKind;
    private int referenceIndex;

    ArrayList<byte[]> getContentList() {
        if (list.size() == 0) {
            list.add(new byte[1]);
            list.add(new byte[2]);
        }
        return list;
    }

    @Override
    public String toString() {
        return "CONSTANT_MethodHandle_info [tag="+tag+" ]";

    }
}
