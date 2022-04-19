package com.nts.jvm.attributeinfo;

public class SourceDebugExtension_attribute  extends  AttributeInfo{

    //u2 attribute_name_index;
    // u4 attribute_length;
    // u1 debug_extension[attribute_length]; }


    @Override
    public String getName() {
        return "SourceDebugExtension";
    }
}
