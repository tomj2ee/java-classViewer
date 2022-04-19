package com.nts.jvm.constantpool;

public class ConstantPoolFactory {

	/**
	 * get constant pool by type
	 * 
	 * @param type
	 * @return
	 */

	public static CP_info getCp(int type) {

		switch (type) {
	 
		case 1:
			return new CONSTANT_Utf8_info();
		case 3:
			new CONSTANT_Integer_info();
		case 4:
			return new CONSTANT_Float_info();
		case 5:
			return new CONSTANT_Long_info();
		case 6:
			return new CONSTANT_Double_info();
		case 7:
			return new CONSTANT_Class_info();
		case 8:
			return new CONSTANT_String_info();
		case 9:
			return new CONSTANT_Fieldref_info();
		case 10:
			return new CONSTANT_Methodref_info();
		case 11:
			return new CONSTANT_InterfaceMethodref_info();
		case 12:
			return new CONSTANT_NameAndType_info();
		case 15:
			return new CONSTANT_MethodHandle_info();
		case 16:
			return new CONSTANT_MethodType_info();

		case 18:
			return new CONSTANT_InvokeDynamic_info();

		}
		return null;

	}

}
