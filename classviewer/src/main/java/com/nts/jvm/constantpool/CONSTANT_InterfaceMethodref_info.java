package com.nts.jvm.constantpool;

import java.util.ArrayList;

import com.nts.jvm.util.ByteUtils;

public class CONSTANT_InterfaceMethodref_info extends CP_info {

	// u1 tag CONSTANT_InterfaceMethodref(11)
	// //u2 class_index constant_pool中的索引，CONSTANT_Class_info类型。记录定义该方法的接口。
	// u2 name_and_type_index constant_pool中的索引，CONSTANT_NameAndType_info类型。
	// 指定接口中的方法名（name）和方法描述符（descriptor）

	@Override
	public int getTag() {

		return 11;
	}

	private int classIndex;
	private int nameAndTypeIndex;

	@Override
	public void readContent() throws Exception {

		super.readContent();
		classIndex = (ByteUtils.getInt2(getContentList().get(0))) ;
		nameAndTypeIndex = (ByteUtils.getInt2(getContentList().get(1))) ;
	}

	@Override
	public String toString() {

		 return "CONSTANT_InterfaceMethodref_info [tag=" + tag + "  classIndex=" + classIndex + " nameAndTypeIndex=" + nameAndTypeIndex + "  ]";

	}

	@Override
	ArrayList<byte[]> getContentList() {
		if (list.size() == 0) {
			list.add(new byte[2]);
			list.add(new byte[2]);
		}
		return list;
	}

	public int getClassIndex() {
		return classIndex;
	}

	public int getNameAndTypeIndex() {
		return nameAndTypeIndex;
	}

}
