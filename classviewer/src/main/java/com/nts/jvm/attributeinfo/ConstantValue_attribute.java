package com.nts.jvm.attributeinfo;

import com.nts.jvm.util.ByteUtils;

import java.nio.ByteBuffer;

public class ConstantValue_attribute extends AttributeInfo {
    //u2 attribute_name_index;
    // u4 attribute_length;
    // u2 constantvalue_index;
    public ConstantValue_attribute() {

    }

    public ConstantValue_attribute(AttributeInfo srcAttrInfo) {
        attributeNameIndex = srcAttrInfo.getAttributeNameIndex();
        attributeLength = srcAttrInfo.getAttributeLength();
        getSubAttr(srcAttrInfo.getInfo());
    }

    protected void getSubAttr(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        constantvalueIndex = buffer.getShort();

    }

    private short constantvalueIndex;

    @Override
    public String toString() {


        return "\n[\nConstantValue     \n"

                + "constantvalueIndex:" + constantvalueIndex + "\n"

                + "]"
                ;
    }

    @Override
    public String getName() {
        return "ConstantValue";
    }
}
