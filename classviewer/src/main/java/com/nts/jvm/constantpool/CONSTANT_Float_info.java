package com.nts.jvm.constantpool;

import com.nts.jvm.util.ByteUtils;

import java.util.ArrayList;

public class CONSTANT_Float_info extends CP_info {

	// type descriptor remark
	// u1 tag CONSTANT_Float(4)
	// u4 bytes 单精度浮点型常量值

	private  float floatInfo;

	@Override
	public int getTag() {
		return 4;
	}

	@Override
	public void readContent() throws Exception {
		super.readContent();
		floatInfo = ByteUtils.getInt2(getContentList().get(0));
	}

	@Override
	public String toString() {
		return "CONSTANT_Float_info [tag=" + tag + "   ]";
	}

	@Override
	ArrayList<byte[]> getContentList() {

		if (list.size() == 0) {
			list.add(new byte[4]);
		}
		return list;
	}

	public float getFloatInfo() {
		return floatInfo;
	}
}
