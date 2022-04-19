package com.nts.jvm.util;

public class FileNameUtil {


    public static String getCurrent(String fileName) {
        String fs=fileName;
        int idx = fs.lastIndexOf("/");
        if (idx != -1) {
            return fs.substring(0, idx);
        }
        return fs;
    }

    public static String getName(String fileName) {
        String fs=fileName;
        if(fs.endsWith("/")){
            fs=fs.substring(0,fileName.length()-1);
        }
        return  getExtName(fs);
    }

    /**
     *
     * @param fileName
     * @return
     */
    public static String getExtName(String fileName) {
        String fs=fileName;
        fs=fs.replace("\\","/");
        int idx = fs.lastIndexOf("/");
        if (idx != -1) {
            return fs.substring(idx + 1);
        }
        return fs;
    }

}
