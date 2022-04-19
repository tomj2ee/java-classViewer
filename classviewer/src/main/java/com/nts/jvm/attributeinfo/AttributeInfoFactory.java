package com.nts.jvm.attributeinfo;

import com.nts.jvm.constantpool.CONSTANT_Utf8_info;
import com.nts.jvm.constantpool.CP_info;

import java.util.HashMap;

public class AttributeInfoFactory {


    /**
     * get sub attribute
     *
     * @param list
     * @param srcInfo
     * @return
     */

    public static AttributeInfo getAttribute(HashMap<Integer, CP_info> list, AttributeInfo srcInfo) {


        if (srcInfo.getInfo() == null) {
            return srcInfo;
        }


        CP_info cpInfo = list.get(srcInfo.getAttributeNameIndex());
        if (cpInfo == null) return srcInfo;


        if (cpInfo instanceof CONSTANT_Utf8_info) {
            CONSTANT_Utf8_info utf8Info = (CONSTANT_Utf8_info) cpInfo;
            String attrName = utf8Info.getUtf8();

            if (attrName.equals("Code")) {
                return new Code_attribute(srcInfo);
            }
        }
        return srcInfo;

    }


}
