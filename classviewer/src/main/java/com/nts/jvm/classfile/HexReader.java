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
            int size = in.available();
            bytes = new byte[size];
            byte[] buf=new byte[256];
            int pos=0;
            while ( pos<=size){
                int readLen = in.read(buf);
                if(readLen<=0){
                    break;
                }
                System.arraycopy(buf,0,bytes,pos,readLen);
                pos=pos+readLen;
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
           if(in!=null){
               try {
                   in.close();
               }catch (Exception ignored){

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
