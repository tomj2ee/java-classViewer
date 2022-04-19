package com.nts.jvm.constantpool;

import java.util.ArrayList;

import com.nts.jvm.util.ByteUtils;

public class CONSTANT_String_info extends CP_info {

	// CONSTANT_String(8)

	// string_index constant_pool中的索引，CONSTANT_Utf8_info类型。表示String类型值。
	@Override
	public int getTag() {

		return 8;
	}

	@Override
	public void readContent() throws Exception {

		super.readContent();
		stringIndex = ByteUtils.getInt2(getContentList().get(0)) ;
	}

	@Override
	ArrayList<byte[]> getContentList() {

		if (list.size() == 0) {
			list.add(new byte[2]);
		}
		return list;
	}

	private int stringIndex;

	public int getStringIndex() {
		return stringIndex;
	}

	@Override
	public String toString() {

		 return "CONSTANT_String_info [tag=" + tag + "  stringIndex=" + stringIndex + "  ]";
		// return "String "+cpList.get(stringIndex)   ;
	}

}
