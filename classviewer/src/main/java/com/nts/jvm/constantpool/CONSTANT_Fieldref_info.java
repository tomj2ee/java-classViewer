package com.nts.jvm.constantpool;

import com.nts.jvm.util.ByteUtils;

import java.util.ArrayList;

public class CONSTANT_Fieldref_info extends CP_info {

    // u1 tag CONSTANT_Fieldref(9)
    // u2 class_index constant_pool中的索引，CONSTANT_Class_info类型。记录定义该字段的类或接口。
    // u2 name_and_type_index constant_pool中的索引，CONSTANT_NameAndType_info类型。
    // 指定类或接口中的字段名（name）和字段描述符（descriptor）。

    @Override

    public int getTag() {

        return 9;
    }

    @Override
    public void readContent() throws Exception {
        super.readContent();
        classIndex = ByteUtils.getInt2(getContentList().get(0));
        nameAndTypeIndex = ByteUtils.getInt2(getContentList().get(1));
    }

    private int classIndex;
    private int nameAndTypeIndex;

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public String toString() {
        return "CONSTANT_Fieldref_info [tag=" + tag + " classIndex=" + classIndex + " nameAndTypeIndex=" + nameAndTypeIndex + "    ]";
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
