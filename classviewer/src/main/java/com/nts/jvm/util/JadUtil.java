package com.nts.jvm.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler;
import org.jetbrains.java.decompiler.main.extern.IFernflowerPreferences;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JadUtil {

    private static Map<String, Object> options = new HashMap<>();

    static {

        options.put(IFernflowerPreferences.REMOVE_BRIDGE, "0");
        options.put(IFernflowerPreferences.LAMBDA_TO_ANONYMOUS_CLASS, "1");
        options.put(IFernflowerPreferences.BYTECODE_SOURCE_MAPPING, "0");
        options.put(IFernflowerPreferences.DUMP_ORIGINAL_LINES, "0");

    }


    /**
     * @param bytes
     * @return
     * @throws IOException
     */
    public static String doDecompiler(byte[] bytes) {
        String code = "";
        try {
            String strDir = System.getProperty("user.home");
            String path = strDir.replace('\\', '/') + "/classviwer/";
            new File(path).mkdirs();
            String name = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssZZ");
            String fullName = path + name + ".class";
            File destClassFile = new File(fullName);
            FileUtils.writeByteArrayToFile(new File(fullName), bytes);
            code = doDecompiler(fullName);
            destClassFile.delete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return code;
    }

    public static String doDecompiler(String filePath) {
        try {
            File f = new File(filePath);
            File p = f.getParentFile();
            ConsoleDecompiler decompiler = new ConsoleDecompiler(p, options);
            File classFile = new File(filePath);
            decompiler.addSpace(classFile, true);
            decompiler.decompileContext();
            String testName = classFile.getName().substring(0, classFile.getName().length() - 6);
            File decompiledFile = new File(p.getAbsolutePath(), testName + ".java");
            return FileUtils.readFileToString(decompiledFile);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        String code = new JadUtil().doDecompiler("D:\\all_project\\github\\java-classViewer\\classviewer\\target\\classes\\com\\nts\\jvm\\ClassViewFrame.class");
        System.out.println(code);
    }

}
