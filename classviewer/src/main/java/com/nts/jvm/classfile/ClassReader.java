package com.nts.jvm.classfile;

import com.nts.jvm.attributeinfo.AttributeInfo;
import com.nts.jvm.buff.PcBufferInputStream;
import com.nts.jvm.buff.Record;
import com.nts.jvm.constantpool.CP_info;
import com.nts.jvm.constantpool.ConstantPoolFactory;
import com.nts.jvm.fieldinfo.FieldInfo;
import com.nts.jvm.methodinfo.MethodInfo;
import com.nts.jvm.util.ByteUtils;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hcmfys@163.com
 */
public class ClassReader {

    // class文件
    // 类型 名称 数量
    // u4 magic 1
    private int magic;
    // u2 minor_version 1
    private int minorVersion;

    // u2 major_version 1
    private int majorVersion;
    // u2 constant_pool_count 1
    private int constantPoolCount;


    private Map<String, Record> recordMap = new LinkedHashMap<>();

    private void doRecord(String type, int startPc, int endPc) {
        recordMap.put(type, new Record(startPc, endPc));
    }


    // cp_info constant_pool constant_pool_count - 1
    // u2 access_flags 1
    // u2 this_class 1
    // u2 super_class 1
    // u2 interfaces_count 1
    // u2 interfaces interfaces_count
    // u2 fields_count 1
    // field_info fields fields_count
    // u2 methods_count 1
    // method_info methods methods_count
    // u2 attribute_count 1
    // attribute_info attributes attributes_count

    // 在class文件开头的四个字节，存放着class文件的魔数，
    // 这个魔数是class文件的标志，
    // 他是一个固定的值： 0XCAFEBABE 。
    // 也就是说他是判断一个文件是不是class格式的文件的标准，
    // 如果开头四个字节不是0XCAFEBABE， 那么就说明它不是class文件，
    // 不能被JVM识别。

    /**
     * @param in
     * @return
     * @throws Exception
     */

    private int readMagic(PcBufferInputStream in) throws Exception {
        int sp = in.getPc();
        byte[] magic = new byte[4];
        int len = in.read(magic);
        if (len != 4) {
            throw new Exception(" read magic error !");
        }
        int ep = in.getPc();
        doRecord("magic", sp, ep);
        return ByteUtils.getInt4(magic);
    }

    /**
     * 次要版本
     *
     * @param in
     * @throws Exception
     */

    private int readMinorVersion(PcBufferInputStream in) throws Exception {
        byte[] bytes = new byte[2];
        int sp = in.getPc();
        int len = in.read(bytes);
        if (len != 2) {
            throw new Exception(" read majorVersion error !");
        }
        minorVersion = ByteUtils.getInt2(bytes);
        P("次要版本:" + minorVersion);
        int ep = in.getPc();
        doRecord("minorVersion", sp, ep);
        return minorVersion;
    }

    /**
     * 主要版本
     *
     * @param in
     * @throws Exception
     */
    private int readMajorVersion(PcBufferInputStream in) throws Exception {
        byte[] bytes = new byte[2];
        int sp = in.getPc();
        int len = in.read(bytes);
        if (len != 2) {
            throw new Exception(" read majorVersion error !");
        }
        int ep = in.getPc();
        doRecord("majorVersion", sp, ep);
        majorVersion = ByteUtils.getInt2(bytes);
        P("主要版本:" + majorVersion);
        return majorVersion;

    }

    private static void P(String info) {
        // System.out.println(info);
    }

    /**
     * 读取constant_pool_count数目
     *
     * @param in
     * @throws Exception
     */

    private int readConstantPoolCount(PcBufferInputStream in) throws Exception {
        byte[] poolCountBytes = new byte[2];
        int sp = in.getPc();
        int len = in.read(poolCountBytes);
        if (len != 2) {
            throw new Exception(" read constant_pool_count error !");
        }
        int ep = in.getPc();
        constantPoolCount = ByteUtils.getInt2(poolCountBytes);
        doRecord("constantPoolCount", sp, ep);
        // P("constant_pool_count=" + constantPoolCount);
        return constantPoolCount;
    }

    private HashMap<Integer, CP_info> cpMap;

    /**
     * @param in
     */

    private HashMap<Integer, CP_info> readCpInfo(PcBufferInputStream in) throws Exception {

        cpMap = new HashMap<Integer, CP_info>();
        for (int i = 1; i <= constantPoolCount - 1; i++) {
            byte[] cpBytes = new byte[1];
            int sp = in.getPc();
            int len = in.read(cpBytes);
            if (len != 1) {
                throw new Exception(" read constant_pool_count info  error !");
            }
            int tag = ByteUtils.getInt1(cpBytes[0]);

            CP_info cpInfo = ConstantPoolFactory.getCp(tag);

            cpInfo.setTag(tag);
            cpInfo.setIndex(i);
            cpInfo.setInput(in);
            cpInfo.readContent();
            int ep = in.getPc();
            cpMap.put(i, cpInfo);
            doRecord("cp-" + i, sp, ep);
            if (tag == 5 || tag == 6) {
                ++i;
            }
        }

        return cpMap;
    }

    // u2 access_flags 1

    private int readAccessFlags(PcBufferInputStream in) throws Exception {
        byte[] bytes = new byte[2];
        int sp = in.getPc();
        in.read(bytes);
        int ep = in.getPc();
        doRecord("accessFlags", sp, ep);
        return ByteUtils.getInt2(bytes);
    }

    // u2 this_class 1

    private int readThisClass(PcBufferInputStream in) throws Exception {
        byte[] bytes = new byte[2];
        int sp = in.getPc();
        in.read(bytes);
        int ep = in.getPc();
        doRecord("thisClass", sp, ep);
        return ByteUtils.getInt2(bytes);

    }

    // u2 super_class 1

    private int readSuperClass(PcBufferInputStream in) throws Exception {
        byte[] bytes = new byte[2];
        int sp = in.getPc();
        in.read(bytes);
        int ep = in.getPc();
        doRecord("superClass", sp, ep);
        return ByteUtils.getInt2(bytes);
    }

    // u2 interfaces_count 1

    private int interfacesCount;

    private int readInterfacesCount(PcBufferInputStream in) throws Exception {
        byte[] bytes = new byte[2];
        int sp = in.getPc();
        in.read(bytes);
        interfacesCount = ByteUtils.getInt2(bytes);
        int ep = in.getPc();
        doRecord("interfacesCount", sp, ep);
        return interfacesCount;
    }

    // u2 interfaces interfaces_count
    private ArrayList<Integer> readInterfaces(PcBufferInputStream in) throws Exception {
        ArrayList<Integer> interList = new ArrayList<Integer>();
        for (int i = 0; i < interfacesCount; i++) {
            int sp = in.getPc();
            byte[] bytes = new byte[2];
            in.read(bytes);
            int ep = in.getPc();
            int iIndex = ByteUtils.getInt2(bytes);
            doRecord("readInterfaces-" + i, sp, ep);
            interList.add(iIndex);
        }
        return interList;
    }

    // u2 fields_count 1

    private int fieldsCount;

    private int readFieldsCount(PcBufferInputStream in) throws Exception {

        byte[] bytes = new byte[2];
        int sp = in.getPc();
        in.read(bytes);
        int ep = in.getPc();
        fieldsCount = ByteUtils.getInt2(bytes);
        doRecord("fieldsCount-", sp, ep);
        return fieldsCount;
    }

    // field_info fields fields_count

    private ArrayList<FieldInfo> readFields(PcBufferInputStream in) throws Exception {
        ArrayList<FieldInfo> list = new ArrayList<FieldInfo>();
        for (int i = 0; i < fieldsCount; i++) {
            FieldInfo fileInfo = new FieldInfo();
            int sp = in.getPc();
            fileInfo.setCpInfoList(cpMap);
            fileInfo.readContent(in);
            int ep = in.getPc();
            doRecord("readFields-" + i, sp, ep);
            list.add(fileInfo);
        }
        return list;
    }

    // u2 methods_count 1

    private int methodsCount;

    private int readMethodsCount(PcBufferInputStream in) throws Exception {
        int sp = in.getPc();
        byte[] bytes = new byte[2];
        in.read(bytes);
        int ep = in.getPc();
        methodsCount = ByteUtils.getInt2(bytes);
        doRecord("readMethodsCount", sp, ep);
        return methodsCount;
    }

    // method_info methods methods_count

    private ArrayList<MethodInfo> readMethods(PcBufferInputStream in) throws Exception {
        ArrayList<MethodInfo> methodInfos = new ArrayList<MethodInfo>();
        for (int i = 0; i < methodsCount; i++) {
            int sp = in.getPc();
            MethodInfo methodInfo = new MethodInfo();
            methodInfo.setCpInfoList(cpMap);
            methodInfo.readContent(in);
            int ep = in.getPc();
            methodInfos.add(methodInfo);
            doRecord("readMethods-" + i, sp, ep);
        }
        return methodInfos;
    }

    // u2 attribute_count 1

    private int attributeCount;

    private int readAttributeCount(PcBufferInputStream in) throws Exception {

        byte[] bytes = new byte[2];
        int sp = in.getPc();
        in.read(bytes);
        int ep = in.getPc();
        attributeCount = ByteUtils.getInt2(bytes);
        doRecord("readAttributeCount", sp, ep);
        return attributeCount;
    }

    // attribute_info attributes attributes_count

    private ArrayList<AttributeInfo> readAttributes(PcBufferInputStream in) throws Exception {
        ArrayList<AttributeInfo> list = new ArrayList<AttributeInfo>();
        for (int i = 0; i < attributeCount; i++) {
            int sp = in.getPc();
            AttributeInfo info = new AttributeInfo();
            info.readContent(in);
            int ep = in.getPc();
            doRecord("readAttributes-" + i, sp, ep);
            list.add(info);
        }
        return list;
    }

    public ClassFile readClassFile(byte[] bytes) throws Exception {
        return  readClassFile(new ByteArrayInputStream(bytes));
    }

    public ClassFile readClassFile(InputStream input) throws Exception {
        ClassFile classFile = new ClassFile();
        PcBufferInputStream in = new PcBufferInputStream(input);
        classFile.setMagic(readMagic(in));
        classFile.setMinorVersion(readMinorVersion(in));
        classFile.setMajorVersion(readMajorVersion(in));
        classFile.setConstantPoolCount(readConstantPoolCount(in));
        classFile.setCpInfo(readCpInfo(in));
        classFile.setAccessFlags(readAccessFlags(in));
        classFile.setThisClass(readThisClass(in));
        classFile.setSuperClass(readSuperClass(in));
        classFile.setInterfacesCount(readInterfacesCount(in));
        // u2 interfaces interfaces_count
        classFile.setInterfaces(readInterfaces(in));
        // u2 fields_count
        classFile.setFieldsCount(readFieldsCount(in));
        // field_info fields fields_count
        classFile.setFields(readFields(in));
        // u2 methods_count 1
        // method_info methods methods_count
        classFile.setMethodsCount(readMethodsCount(in));
        classFile.setMethods(readMethods(in));
        // u2 attribute_count 1
        classFile.setAttributeCount(readAttributeCount(in));
        // attribute_info attributes attributes_count
        classFile.setAttributes(readAttributes(in));
        classFile.setPcRecord(recordMap);

        return classFile;
    }

    /**
     * @param fileName
     * @throws Exception
     */
    public ClassFile readClassFile(String fileName) throws Exception {
        FileInputStream in = new FileInputStream(fileName);
        ClassFile cf = readClassFile(in);
        in.close();
        return cf;
    }

}
