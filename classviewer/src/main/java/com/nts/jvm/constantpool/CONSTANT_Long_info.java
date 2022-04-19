package com.nts.jvm.constantpool;

import com.nts.jvm.util.ByteUtils;

import java.util.ArrayList;

public class CONSTANT_Long_info extends CP_info {

	// type descriptor remark
	// u1 tag CONSTANT_Long (5)

	// u4 high_bytes 长整型的高四位值
	// u4 low_bytes 长整型的低四位值

	private  long intergerInfo=0;
	@Override
	public int getTag() {
		return 5;
	}

	@Override
	public void readContent() throws Exception {
		super.readContent();
		byte[] b=new byte[8];
		byte[] b1=getContentList().get(0);
		byte[] b2=getContentList().get(1);
		for(int i=0;i<4;i++){
			b[i]=b1[i];
		}
		for(int i=0;i<4;i++){
			b[4+i]=b2[i];
		}
		intergerInfo = ByteUtils.getInt8(b);
	}

	@Override
	public String toString() {
		return "CONSTANT_Long_info [tag=" + tag + "  high_bytes=" + 0 + " low_bytes=" + 0 + "  ]";
	}

	@Override
	ArrayList<byte[]> getContentList() {

		if (list.size() == 0) {
			list.add(new byte[4]);
			list.add(new byte[4]);
		}
		return list;
	}

	public long getIntergerInfo() {
		return intergerInfo;
	}
}
