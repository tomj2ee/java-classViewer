package com.nts.jvm.attributeinfo;

import java.nio.ByteBuffer;

public class Code_attribute extends AttributeInfo {


    public Code_attribute() {

    }

    public Code_attribute(AttributeInfo srcAttrInfo) {
        attributeNameIndex = srcAttrInfo.getAttributeNameIndex();
        attributeLength = srcAttrInfo.getAttributeLength();
        getSubAttr(srcAttrInfo.getInfo());
    }

    // u2 attribute_name_index;
    // u4 attribute_length;
    // u2 max_stack;
    // u2 max_locals;
    // u4 code_length;
    //
    // u1 code[code_length];
    // u2 exception_table_length;
    // {
    //      u2 start_pc;
    //      u2 end_pc;
    //      u2 handler_pc;
    //      u2 catch_type;
    // }
    // exception_table[exception_table_length];
    // u2 attributes_count;
    // attribute_info attributes[attributes_count];


    protected void getSubAttr(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        maxStack = buffer.getShort();
        maxLocals = buffer.getShort();
        codeLength = buffer.getInt();

        if (codeLength > 0) {
            code = new byte[codeLength];
            for (int i = 0; i < codeLength; i++) {
                code[i] = buffer.get();
            }
        }
        exceptionTableLength = buffer.getShort();
        if (exceptionTableLength > 0) {
            exceptionTable = new Exception_table[exceptionTableLength];
            for (int i = 0; i < exceptionTableLength; i++) {
                Exception_table exTab = new Exception_table();
                exTab.setStartPc(buffer.getShort());
                exTab.setEndPc(buffer.getShort());
                exTab.setHandlerPc(buffer.getShort());
                exTab.setCatchType(buffer.getShort());
                exceptionTable[i] = exTab;
            }
        }
        attributesCount = buffer.getShort();
        if (attributesCount > 0) {
            attributes = new AttributeInfo[attributesCount];

            for (int i = 0; i < attributesCount; i++) {
                AttributeInfo attr = new AttributeInfo();
                attr.readContent(buffer);
                attributes[i] = attr;
            }
        }
    }


    // u2 max_stack;
    private int maxStack;


    // u2 max_locals;
    private int maxLocals;
    // u4 code_length;

    private int codeLength;
    //
    // u1 code[code_length];
    private byte code[];
    // u2 exception_table_length;
    private int exceptionTableLength;
    private Exception_table exceptionTable[];

    public int getMaxStack() {
        return maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public byte[] getCode() {
        return code;
    }

    public int getExceptionTableLength() {
        return exceptionTableLength;
    }

    public Exception_table[] getExceptionTable() {
        return exceptionTable;
    }

    public short getAttributesCount() {
        return attributesCount;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    private short attributesCount;
    private AttributeInfo attributes[];

    @Override
    public String toString() {
        return "\n[\nCode  " + " max_stack:" + maxStack + "\n"

                + "max_locals:" + maxLocals + "\n"
                + "code_length:" + codeLength + "\n"
                + "]"
                ;
    }

    @Override
    public String getName() {
        return "Code";
    }
}
