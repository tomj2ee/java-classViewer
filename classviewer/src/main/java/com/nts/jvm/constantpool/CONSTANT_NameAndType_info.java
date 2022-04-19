package com.nts.jvm.constantpool;

import java.util.ArrayList;

import com.nts.jvm.util.ByteUtils;

public class CONSTANT_NameAndType_info extends CP_info {

    // type descriptor remark

    // u1 tag CONSTANT_NameAndType (12)
    // u2 name_index constant_pool中的索引，CONSTANT_Utf8_info类型。指定字段或方法的名称。
    // u2 descriptor_index
    // constant_pool中的索引，CONSTANT_utf8_info类型。指定字段或方法的描述符（见附录C）

    @Override
    public  int getTag() {

        return 12;
    }

    @Override
    public void readContent() throws Exception {

        super.readContent();
        nameIndex = ByteUtils.getInt2(getContentList().get(0));
        descriptorIndex = ByteUtils.getInt2(getContentList().get(1));

    }

    @Override
    public String toString() {

        return "CONSTANT_Methodref_info [tag=" + tag + "  nameIndex=" + nameIndex + " descriptorIndex=" + descriptorIndex + "  ]";
        // return "Methodref " + "#" + nameIndex + ".#" + descriptorIndex +
///
        //   "      //   " +
        //   cpList.get(nameIndex) + " " + cpList.get(descriptorIndex);
    }

    private int descriptorIndex;
    private int nameIndex;


    @Override
    ArrayList<byte[]> getContentList() {

        if (list.size() == 0) {
            list.add(new byte[2]);
            list.add(new byte[2]);
        }
        return list;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public int getNameIndex() {
        return nameIndex;
    }

}
