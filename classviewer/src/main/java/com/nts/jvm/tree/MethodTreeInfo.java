package com.nts.jvm.tree;

public class MethodTreeInfo {

    public MethodTreeInfo(){

    }

    public MethodTreeInfo(String methodName,int startIndex,int endIndex,int type){
        this.methodName=methodName;
        this.startIndex=startIndex;
        this.endIndex=endIndex;
        this.type=type;
    }
    private String code;

    private  int type;
    private  String methodName="";

    private  int startIndex;

    private  int endIndex;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return methodName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
