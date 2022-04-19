package com.nts.jvm.constantpool;

import com.nts.jvm.util.ByteUtils;

import java.util.ArrayList;

public class CONSTANT_MethodType_info extends CP_info {
    public  int getTag() {
        return 16;
    }


    @Override
    public void readContent() throws Exception {
        super.readContent();
        descriptorIndex = ByteUtils.getInt2(getContentList().get(0));
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    private int descriptorIndex;

    ArrayList<byte[]> getContentList() {

        if (list.size() == 0) {

            list.add(new byte[2]);
        }
        return list;
    }

    @Override
    public String toString() {
        return "MethodType  #" + descriptorIndex;

    }
}
