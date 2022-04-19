package com.nts.jvm.constantpool;

import java.util.ArrayList;

import com.nts.jvm.util.ByteUtils;

public class CONSTANT_Utf8_info extends CP_info {

	// u1 tag CONSTANT_Utf8 (1)
	// u2 length bytes所代表 的字符串的长度
	// u1 bytes[length]
	// 字符串的byte数据，可以通过DataInputStream中的readUtf()方法（实例方法或静态方法读取该二进制的字符串的值。）
	@Override
    public int getTag() {
		return 1;
	}

	@Override
	public void readContent() throws Exception {

		byte[] u2 = getContentList().get(0);
		input.read(u2);
		int size = ByteUtils.getInt2(u2);
		byte bs[] = new byte[size];
		int strLength = input.read(bs);
		if (bs.length != strLength) {
			throw new Exception("CONSTANT_Utf8 read error tag:" + tag);
		}
		utf8 = new String(bs, "utf-8");

	}

	@Override
	public String toString() {


        return "utf8   "+utf8;
	}

	private String utf8;

	@Override
	ArrayList<byte[]> getContentList() {

		if (list.size() == 0) {
			list.add(new byte[2]);
			list.add(new byte[1]);
		}
		return list;
	}

	public String getUtf8() {
		return utf8;
	}

}
