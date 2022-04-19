package com.nts.jvm.attributeinfo;

import com.nts.jvm.attributeinfo.frame.Stack_map_frame;

import java.nio.ByteBuffer;

public class StackMapTable_attribute  extends  AttributeInfo{
    //u2 attribute_name_index;
    // u4 attribute_length;
    // u2 number_of_entries;
    // stack_map_frame entries[number_of_entries];

    public StackMapTable_attribute(AttributeInfo srcAttrInfo) {
        attributeNameIndex = srcAttrInfo.getAttributeNameIndex();
        attributeLength = srcAttrInfo.getAttributeLength();
        getSubAttr(srcAttrInfo.getInfo());
    }

    protected void getSubAttr(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        numberOfEntries = buffer.getShort();
        if(numberOfEntries>0){
            entries=new Stack_map_frame[numberOfEntries];
        }

    }

    private short numberOfEntries;
    private Stack_map_frame entries[];

    @Override
    public String toString() {


        return "\n[\nStackMapTable     \n"

                + "numberOfEntries:" + numberOfEntries + "\n"

                + "]"
                ;
    }


    @Override
    public String getName() {
        return "StackMapTable";
    }
}
