package com.nts.jvm.constantpool;

import java.io.InputStream;
import java.util.ArrayList;


public abstract class CP_info {

	protected InputStream input;

	protected ArrayList<byte[]> list = new ArrayList<byte[]>();

	public void setInput(InputStream in) {
		this.input = in;
	}

	protected int tag;

	public void setTag(int tag) {
		this.tag = tag;
	}


	public void readContent() throws Exception {
		ArrayList<byte[]> list = getContentList();
		for (byte[] bs : list) {
			int len = input.read(bs);
			if (len != bs.length) {
				throw new Exception("CP_info readContent read error  tag:" + getTag());
			}
		}
	}





    public   abstract int getTag();

	private int index;
	public int getIndex(){
	    return index;
    }

    public void setIndex(int index){
	    this.index=index;
    }

	abstract ArrayList<byte[]> getContentList();

}
