package com.nts.jvm.fieldinfo;

import com.nts.jvm.util.AccessFlagsUtils;
import com.nts.jvm.util.ByteUtils;
import com.nts.jvm.attributeinfo.AttributeInfo;
import com.nts.jvm.attributeinfo.AttributeInfoFactory;
import com.nts.jvm.constantpool.CP_info;

import java.io.InputStream;
import java.util.HashMap;

public class FieldInfo {

    //u2 access_flags;
    //u2 name_index;
    //u2 descriptor_index;
    //u2 attributes_count;
    //attribute_info attributes[attributes_count];

    protected HashMap<Integer, CP_info> cpInfoList;

    protected int accessFlags;

    public int getAccessFlags() {
        return accessFlags;
    }

    public HashMap<Integer, CP_info> getCpInfoList() {
        return cpInfoList;
    }

    public void setCpInfoList(HashMap<Integer, CP_info> cpInfoList) {
        this.cpInfoList = cpInfoList;
    }

    public void setAccessFlags(int accessFlags) {
        this.accessFlags = accessFlags;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public int getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(int attributesCount) {
        this.attributesCount = attributesCount;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributeInfo[] attributes) {
        this.attributes = attributes;
    }

    protected int nameIndex;
    protected int descriptorIndex;
    protected int attributesCount;


    protected AttributeInfo attributes[];

    /**
     * @param in
     * @throws Exception
     */

    public void readContent(InputStream in) throws Exception {


        //u2 access_flags;
        //u2 name_index;
        //u2 descriptor_index;
        //u2 attributes_count;
        //attribute_info attributes[attributes_count];

        byte[] bytes = new byte[2];
        in.read(bytes);
        accessFlags = ByteUtils.getInt2(bytes);


        bytes = new byte[2];
        in.read(bytes);
        nameIndex = ByteUtils.getInt2(bytes);

        bytes = new byte[2];
        in.read(bytes);
        descriptorIndex = ByteUtils.getInt2(bytes);


        bytes = new byte[2];
        in.read(bytes);
        attributesCount = ByteUtils.getInt2(bytes);

        if (attributesCount > 0) {
            attributes = new AttributeInfo[attributesCount];
            for (int i = 0; i < attributesCount; i++) {
                AttributeInfo attr = new AttributeInfo();
                attr.setCpInfoList(cpInfoList);
                attr.readContent(in);
                attr = AttributeInfoFactory.getAttribute(cpInfoList, attr);
                attributes[i] = attr;
            }
        }


    }


    public  String  getFieldName(){
        return   AccessFlagsUtils.getNameIndex(nameIndex, cpInfoList)
                +":"+
                AccessFlagsUtils.getFiledPref ( AccessFlagsUtils.getNameIndex(descriptorIndex,
                        cpInfoList));
    }

    public  String  displayCode(){
       return AccessFlagsUtils.getFieldAccess(accessFlags)+ " "+
               AccessFlagsUtils.getFiledPref (  AccessFlagsUtils.getNameIndex(descriptorIndex,
                       cpInfoList)) + " "+
        AccessFlagsUtils.getNameIndex(nameIndex, cpInfoList) +";";
    }
    @Override
    public String toString() {


        //access_flags:
        String ret = AccessFlagsUtils.getFieldAccess(accessFlags)

                + " " + AccessFlagsUtils.getFiledPref(
                        AccessFlagsUtils.getNameIndex(descriptorIndex, cpInfoList))
                + "  " +
                AccessFlagsUtils.getNameIndex(nameIndex, cpInfoList)+";\n"
                ;


        for (int i = 0; i < attributesCount; i++) {
            ret +=    attributes[i];
        }



        return ret;


    }
}
