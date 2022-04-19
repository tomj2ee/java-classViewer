package com.nts.jvm.attributeinfo;

public class LineNumberTable_attribute  extends  AttributeInfo{

    // u2 attribute_name_index; u4 attribute_length;
    // u2 line_number_table_length;
    // {
    // u2 start_pc; u2 line_number;
    // } line_number_table[line_number_table_length];


    @Override
    public String getName() {
        return "LineNumberTable";
    }
}
