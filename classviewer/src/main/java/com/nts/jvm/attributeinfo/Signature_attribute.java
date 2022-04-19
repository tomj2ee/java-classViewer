package com.nts.jvm.attributeinfo;

public class Signature_attribute  extends  AttributeInfo{


    //u2 attribute_name_index;
    // u4 attribute_length;
    // u2 signature_index;


    @Override
    public String getName() {
        return "Signature";
    }
}
