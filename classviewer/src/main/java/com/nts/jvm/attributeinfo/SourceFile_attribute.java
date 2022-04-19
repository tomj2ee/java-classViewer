package com.nts.jvm.attributeinfo;

public class SourceFile_attribute extends  AttributeInfo {

    //u2 attribute_name_index;
    // u4 attribute_length;
    // u2 sourcefile_index;


    @Override
    public String getName() {
        return "SourceFile";
    }
}
