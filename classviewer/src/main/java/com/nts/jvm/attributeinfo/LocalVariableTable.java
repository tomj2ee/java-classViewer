package com.nts.jvm.attributeinfo;

public class LocalVariableTable  extends  AttributeInfo {


    //u2 attribute_name_index;
    // u4 attribute_length;
    // u2 local_variable_table_length;
    // {
    // u2 start_pc; u2 length;
    // u2 name_index;
    // u2 descriptor_index;
    // u2 index;
    // } local_variable_table[local_variable_table_length];


    @Override
    public String getName() {
        return "LocalVariableTable";
    }
}
