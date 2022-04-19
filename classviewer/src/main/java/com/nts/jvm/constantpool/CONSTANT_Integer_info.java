package com.nts.jvm.constantpool;

import com.nts.jvm.util.ByteUtils;

import java.util.ArrayList;

public class CONSTANT_Integer_info extends CP_info {

	// 用于记录int类型的常量值（represent 4-byte numeric (int) constants:）
	// CONSTANT_Integer_info type descriptor remark
	// u1 tag CONSTANT_Integer (3)
	// u4 bytes 整型常量值

	private int intergerInfo;

	@Override
	public String toString() {

		return "CONSTANT_Integer_info [tag=" + tag + " CONSTANT_Integer=" + intergerInfo + "]";

	}

	@Override
	public void readContent() throws Exception {
		super.readContent();
		intergerInfo = ByteUtils.getInt2(getContentList().get(0));
	}

	@Override
	public int getTag() {
		return 3;
	}

	@Override
	ArrayList<byte[]> getContentList() {
		if (list.size() == 0) {
			list.add(new byte[4]);
		}
		return list;
	}

	public int getIntergerInfo() {
		return intergerInfo;
	}
}
