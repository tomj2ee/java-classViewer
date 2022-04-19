package com.nts.jvm.util;

import com.nts.jvm.constantpool.CONSTANT_Utf8_info;
import com.nts.jvm.constantpool.CP_info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AccessFlagsUtils {



    //ACC_PUBLIC 0x0001 可以被包的类外访问。
    //ACC_FINAL 0x0010 不允许有子类。
    //ACC_SUPER 0x0020
    //当用到 invokespecial 指令时，需要特殊处理③的
    //父类方法。
    //ACC_INTERFACE 0x0200 标识定义的是接口而不是类。
    //ACC_ABSTRACT 0x0400 不能被实例化。
    //ACC_SYNTHETIC 0x1000 标识并非 Java 源码生成的代码。
    //ACC_ANNOTATION 0x2000 标识注解类型
    //ACC_ENUM 0x4000 标识枚举类型
    public static String getCLassAccess(int type) {

        StringBuilder sb = new StringBuilder();

        if ((type & 0x0001) > 0) {
            sb.append("public ");
        }
        if ((type & 0x0010) > 0) {
            sb.append("final ");
        }
        if ((type & 0x0200) > 0) {
            sb.append("interface ");
        }
        if ((type & 0x0400) > 0) {
            sb.append("abstract ");
        }


        if ((type & 0x1000) > 0) {
            sb.append("synthetic ");
        }

        if ((type & 0x2000) > 0) {
            sb.append("annotation  ");
        }

        if ((type & 0x4000) > 0) {
            sb.append("enum ");
        }

        return sb.toString();


    }


    // ACC_PUBLIC 0x0001 public，方法可以从包外访问
    // ACC_PRIVATE 0x0002 private，方法只能本类中访问
    // ACC_PROTECTED 0x0004 protected，方法在自身和子类可以访问
    // ACC_STATIC 0x0008 static，静态方法
    // ACC_FINAL 0x0010 final，方法不能被重写（覆盖）
    // ACC_SYNCHRONIZED 0x0020 synchronized，方法由管程同步
    // ACC_BRIDGE 0x0040 bridge，方法由编译器产生
    // ACC_VARARGS 0x0080 表示方法带有变长参数
    // ACC_NATIVE 0x0100 native，方法引用非java语言的本地方法
    // ACC_ABSTRACT 0x0400 abstract，方法没有具体实现
    // ACC_STRICT 0x0800 strictfp，方法使用FP-strict浮点格式
    // ACC_SYNTHETIC 0x1000 方法在源文件中不出现，由编译器产生

    public static String getMethodAccess(int type) {

        StringBuilder sb = new StringBuilder();

        if ((type & 0x0001) > 0) {
            sb.append("public ");
        }
        if ((type & 0x0002) > 0) {
            sb.append("private ");
        }
        if ((type & 0x0004) > 0) {
            sb.append("protected ");
        }

        if ((type & 0x0008) > 0) {
            sb.append("static ");
        }

        if ((type & 0x0010) > 0) {
            sb.append("final ");
        }
        if ((type & 0x0020) > 0) {
            sb.append("synchronized ");
        }

        if ((type & 0x0080) > 0) {
            sb.append(" ... ");
        }

        if ((type & 0x0100) > 0) {
            sb.append("native ");
        }
        if ((type & 0x0400) > 0) {
            sb.append("abstract ");
        }

        return sb.toString();


    }


    public static String getFieldAccess(int type) {

        StringBuffer sb = new StringBuffer();

        if ((type & 0x0001) > 0) {
            sb.append("public ");
        }
        if ((type & 0x0002) > 0) {
            sb.append("private ");
        }
        if ((type & 0x0004) > 0) {
            sb.append("protected ");
        }

        if ((type & 0x0008) > 0) {
            sb.append("static ");
        }

        if ((type & 0x0010) > 0) {
            sb.append("final ");
        }
        if ((type & 0x0020) > 0) {
            sb.append("synchronized ");
        }

        if ((type & 0x0040) > 0) {
            sb.append("volatile ");
        }


        if ((type & 0x4000) > 0) {
            sb.append("enum ");
        }
        if ((type & 0x0080) > 0) {
            sb.append("transient ");
        }


        return sb.toString();


    }

    /**
     * @param nameIndex
     * @param list
     * @return
     */

    public static String getNameIndex(int nameIndex, HashMap<Integer, CP_info> list) {
        StringBuffer sb = new StringBuffer();

        CP_info cpInfo = list.get(nameIndex);
        if (cpInfo instanceof CONSTANT_Utf8_info) {
            CONSTANT_Utf8_info utf8Info = (CONSTANT_Utf8_info) cpInfo;
            sb.append(utf8Info.getUtf8());
        }
        return sb.toString();
    }

    private static HashMap<String, String> ClassnamePrefMap = new HashMap<String, String>();

    static {


        ClassnamePrefMap.put("I", "int");
        ClassnamePrefMap.put("V", "void");
        ClassnamePrefMap.put("B", "byte");
        ClassnamePrefMap.put("C", "char");
        ClassnamePrefMap.put("D", "double");
        ClassnamePrefMap.put("F", "float");
        ClassnamePrefMap.put("Z", "boolean");
        ClassnamePrefMap.put("J", "long");
        ClassnamePrefMap.put("[", "[]");
        //ClassnamePrefMap.put("L","className;");
    }


    /**
     * @param name
     * @return
     */
    public static String getFiledPref(String name) {


        ArrayList<String> parList = new ArrayList<String>();
        String c = "";

        int i=0;
        while (  i<name.length()) {
            String pref = String.valueOf(name.charAt(i));
            if (ClassnamePrefMap.get(pref) != null) {
                parList.add(ClassnamePrefMap.get(pref));
            } else if (pref.equals("L")) {
                int index = name.indexOf(";",i);
                if (index != -1) {
                    String parName = name.substring(i + 1, index).replace("/", ".");
                    int sIndex = parName.lastIndexOf(".");
                    if (sIndex > 0) {
                        parName = parName.substring(sIndex + 1);
                    }
                    parList.add(parName);
                    i = index;
                }
            }
            i++;
        }
        Iterator<String> iters = parList.iterator();
        while (iters!=null && iters.hasNext()) {

            String next = iters.next();
            if (next == null) {
                break;
            }

            if (next.equals("[]")) {
                String array = next;

                while (true) {
                    try {
                        String curNext = iters.next();
                        if (curNext == null) {
                            break;
                        }
                        if (!curNext.equals("[]")) {
                            c += curNext + array + ",";
                            break;
                        } else {
                            array += curNext;
                        }
                    }catch (Exception ex){
                        break;
                    }
                }
            } else {
                c += next + ",";
            }

        }


        if (c.endsWith(",")) {
            c = c.substring(0, c.length() - 1);
        }
        return c;

    }

    /**
     * @param methodName
     * @param descriptorName
     * @return
     */

    public static String getMethodName(String methodName, String descriptorName) {


        int lastIndex = descriptorName.lastIndexOf(")");
        String c = descriptorName.substring(lastIndex + 1).trim();

        String methodPars = descriptorName.substring(0, lastIndex + 1).trim();
        //System.out.println("descriptorName=" + descriptorName + " c=" + c);
        c = getFiledPref(c);

        return c + " " + methodName + "(" + getFiledPref(methodPars) + ")";

    }

    public static void main(String[] args) {
        AccessFlagsUtils.getFiledPref("(Ljava/lang/Void;Ljava/lang/ClassLoader;)");
    }
}
