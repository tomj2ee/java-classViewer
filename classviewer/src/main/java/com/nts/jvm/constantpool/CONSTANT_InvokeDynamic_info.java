package com.nts.jvm.constantpool;

import com.nts.jvm.util.ByteUtils;

import java.util.ArrayList;

public class CONSTANT_InvokeDynamic_info extends CP_info {

    public int getTag() {
        return 18;
    }

    @Override
    public void readContent() throws Exception {

        super.readContent();

        bootStrapMethodAttrIndex = ByteUtils.getInt2(getContentList().get(0)) ;
        nameAndTypeIndex = ByteUtils.getInt2(getContentList().get(1)) ;
    }

    private int bootStrapMethodAttrIndex;

    private int nameAndTypeIndex;

    public int getBootStrapMethodAttrIndex() {
        return bootStrapMethodAttrIndex;
    }

    public void setBootStrapMethodAttrIndex(int bootStrapMethodAttrIndex) {
        this.bootStrapMethodAttrIndex = bootStrapMethodAttrIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(int nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    @Override
    public String toString() {

        return "CONSTANT_InvokeDynamic_info [tag=" + tag + "  bootStrapMethodAttrIndex="
                + bootStrapMethodAttrIndex + " nameAndTypeIndex=" + nameAndTypeIndex + "  ]";

    }

    @Override
    ArrayList<byte[]> getContentList() {

        if (list.size() == 0) {

            list.add(new byte[2]);
            list.add(new byte[2]);
        }
        return list;
    }
}
