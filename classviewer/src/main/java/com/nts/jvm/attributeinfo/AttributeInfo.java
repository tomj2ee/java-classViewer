package com.nts.jvm.attributeinfo;

import com.nts.jvm.util.ByteUtils;
import com.nts.jvm.constantpool.CP_info;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class AttributeInfo {


    // u2 attribute_name_index;
    // u4 attribute_length;
    // u1 info[attribute_length];

    protected int attributeNameIndex;
    protected int attributeLength;
    protected byte info[];

    public int getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(int attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public int getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(int attributeLength) {
        this.attributeLength = attributeLength;
    }

    public byte[] getInfo() {
        return info;
    }

    public void setInfo(byte[] info) {
        this.info = info;
    }


    public HashMap<Integer, CP_info> getCpInfoList() {
        return cpInfoList;
    }


    public void readContent(ByteBuffer in)   {

        attributeNameIndex = in.getShort();
        attributeLength = in.getInt();

        if (attributeLength > 0) {
            info = new byte[attributeLength];
            for (int i = 0; i < info.length; i++) {
                info[i] = in.get();
            }
        }
    }

    public void readContent(InputStream in) throws Exception {


        // u2 attribute_name_index;
        // u4 attribute_length;
        // u1 info[attribute_length];


        byte[] bytes = new byte[2];
        int size = in.read(bytes);

        if (size != bytes.length) {
            throw new Exception(" read AttributeInfo 2 bytes  error ");
        }
        attributeNameIndex = ByteUtils.getInt2(bytes);


        bytes = new byte[4];
        size = in.read(bytes);

        if (size != bytes.length) {
            throw new Exception(" read AttributeInfo 4 bytes  error ");
        }

        attributeLength = ByteUtils.getInt4(bytes);


        if (attributeLength > 0) {
            info = new byte[attributeLength];
            size = in.read(info);
            if (size != info.length) {
                throw new Exception(" read AttributeInfo  attributeLength error ");
            }
        }


    }


    private HashMap<Integer, CP_info> cpInfoList;

    public void setCpInfoList(HashMap<Integer, CP_info> cpInfoList) {
        this.cpInfoList = cpInfoList;
    }



    public  String getName(){
        return "";
    }
}
