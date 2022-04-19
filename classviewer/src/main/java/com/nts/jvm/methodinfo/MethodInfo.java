package com.nts.jvm.methodinfo;

import com.nts.jvm.fieldinfo.FieldInfo;
import com.nts.jvm.util.AccessFlagsUtils;

import java.io.InputStream;

public class MethodInfo extends FieldInfo {

    public MethodInfo() {

    }


    // u2 access_flags;
    // u2 name_index;
    // u2 descriptor_index;
    // u2 attributes_count;
    // attribute_info attributes[attributes_count];


    @Override
    public void readContent(InputStream in) throws Exception {
        super.readContent(in);
    }

    public String getName() {
        String methodName = AccessFlagsUtils.getNameIndex(nameIndex, cpInfoList).trim();
        String descriptorName = AccessFlagsUtils.getNameIndex(descriptorIndex, cpInfoList).trim();
        String showName = AccessFlagsUtils.getMethodName(methodName, descriptorName);
        int idx = showName.indexOf(" ");
        if (idx != -1) {
            return showName.substring(idx + 1).trim() + " :" + showName.substring(0, idx).trim();
        }
        return showName;
    }

    public String getPrintName() {
        String methodName = AccessFlagsUtils.getNameIndex(nameIndex, cpInfoList).trim();

        String descriptorName = AccessFlagsUtils.getNameIndex(descriptorIndex, cpInfoList).trim();

        //access_flags:
        String ret = AccessFlagsUtils.getFieldAccess(accessFlags) +

                AccessFlagsUtils.getMethodName(methodName, descriptorName);

        return ret;

    }

    @Override
    public String toString() {


        String methodName = AccessFlagsUtils.getNameIndex(nameIndex, cpInfoList).trim();
        String descriptorName = AccessFlagsUtils.getNameIndex(descriptorIndex, cpInfoList).trim();

        //  System.out.println("---start method >> "+ AccessFlagsUtils.getMethodName(methodName, descriptorName));
        //access_flags:
        String ret = AccessFlagsUtils.getFieldAccess(accessFlags) +

                AccessFlagsUtils.getMethodName(methodName, descriptorName);


        for (int i = 0; i < attributesCount; i++) {
            ret += " \n" + super.attributes[i];
        }
        ret += "\n";
        return ret;


    }

}
