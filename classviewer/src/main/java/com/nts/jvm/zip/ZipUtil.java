package com.nts.jvm.zip;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtil {

    public static List<String> readClassyByJarFile(String jarFileName) {
        List<String> list = new ArrayList<>();
        try {
            ZipFile zipFile = new ZipFile(jarFileName);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry != null) {
                    String fileName = entry.getName();
                    if( true || !entry.isDirectory()) {
                        if(true || fileName.endsWith(".class")) {
                            list.add(fileName);
                            InputStream in = zipFile.getInputStream(entry);
                            int sz = in.available();
                            System.out.println(fileName + ">>>" + sz);
                        }
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static void main(String[] args) {

        readClassyByJarFile("/Volumes/f/project/job/java-classViewer/classviewer/target/classviewer-1.0-jar-with-dependencies.jar");
    }

}
