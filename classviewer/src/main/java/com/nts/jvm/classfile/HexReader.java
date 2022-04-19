package com.nts.jvm.classfile;


import com.nts.jvm.util.ByteUtils;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class HexReader {

    /**
     * @param
     * @return
     * @throws Exception
     */

    public byte[] readBytes(InputStream in) {
        byte[] bytes;
        try {
            int len = in.available();
            bytes = new byte[(int) len];
            int readLength = in.read(bytes);
            if ((long) readLength < len) {
                throw new RuntimeException("File length is "+len +"  but read  "+ readLength);
            }
        } catch (Exception var10) {
            throw new RuntimeException(var10);
        } finally {
           if(in!=null){
               try {
                   in.close();
               }catch (Exception ex){

               }
           }
        }
        return bytes;
    }

    public String readClassFile(String className) {
        try {
            FileInputStream fin = new FileInputStream(className);
            return readClassFile(fin);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public String readClassFile(InputStream in) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            if (i < 10) {
                sb.append("0");
            }
            sb.append(i + "\t");
        }
        sb.append("\n");
        try {
            byte[] bytes = readBytes(in);
            for (int i = 0; i < bytes.length; i++) {
                sb.append(ByteUtils.toHex(bytes[i]));
                int p = i + 1;
                if (p % 16 == 0) {
                    sb.append("\n");
                } else {
                    sb.append("\t");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sb.toString().toUpperCase();
    }

    public String getString(byte[] codes) {
        return readClassFile(new ByteArrayInputStream(codes));
    }
}
