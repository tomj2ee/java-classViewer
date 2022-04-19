package com.nts.jvm.attributeinfo;

public class Exceptions_attribute  extends  AttributeInfo{


    //u2 attribute_name_index;
    // u4 attribute_length;
    // u2 number_of_exceptions;
    // u2 exception_index_table[number_of_exceptions];


    @Override
    public String getName() {
        return "Exceptions";
    }
}
