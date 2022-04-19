package com.nts.jvm.util;

public class CodeUtil {

    public   static  String toErrorCode(byte[] codes){

        //System.out.println(toHexCode(codes));
        StringBuilder sb=new StringBuilder();
        sb.append("----error code---\n");
        sb.append("{");
        for(byte b :codes){
            sb.append( b+" ,");
        }
        sb.append("}");
        sb.append("----error code end ---\n");
        return  sb.toString();
    }

    public  static  String toHexCode(byte[] codes){
        StringBuilder sb=new StringBuilder();

        for(byte b :codes){
            sb.append( Integer.toHexString((int)b & 0xff)+" ,");
        }

        return  sb.toString();
    }
}
