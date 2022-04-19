package com.nts.jvm.conf;

import com.nts.jvm.util.FileConfUtil;

import java.util.List;

public class ConfFileList {

    public static List<String> getConfFileList() {
        return FileConfUtil.readConf("classPath");
    }

    public static void saveConf(String classFile) {
        List<String> dataList = getConfFileList();
        if (!dataList.contains(classFile)) {
            dataList.add(classFile);
        }
        FileConfUtil.saveConf("classPath", dataList);
    }

    public static void removeFile(String classFile) {
        List<String> dataList = getConfFileList();
        dataList.remove(classFile);
        FileConfUtil.saveConf("classPath", dataList);
    }
}
