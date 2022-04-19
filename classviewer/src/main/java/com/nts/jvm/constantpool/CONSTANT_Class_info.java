package com.nts.jvm.constantpool;

import java.util.ArrayList;

import com.nts.jvm.util.ByteUtils;

public class CONSTANT_Class_info extends CP_info {

    public CONSTANT_Class_info() {

    }

    private int nameIndex;

    // CONSTANT_Class_info format
    // u1 tag CONSTANT_Class (7)
    // u2 name_index constant_pool中的索引，CONSTANT_Utf8_info类型。表示类或接口名。

    @Override
    public String toString() {

        return "CONSTANT_Class_info [tag=" + tag + " name_index=" + nameIndex + "]";


    }

    @Override
    public int getTag() {

        return 7;
    }

    @Override
    public void readContent() throws Exception {

        super.readContent();
        nameIndex = ByteUtils.getInt2(getContentList().get(0)) ;
    }

    @Override
    ArrayList<byte[]> getContentList() {
        if (list.size() == 0) {
            list.add(new byte[2]);
        }
        return list;

    }

    public int getNameIndex(){
        return nameIndex;
    }

}
