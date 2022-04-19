package com.nts.jvm.classfile;

import com.nts.jvm.attributeinfo.AttributeInfo;
import com.nts.jvm.attributeinfo.AttributeInfoFactory;
import com.nts.jvm.attributeinfo.Code_attribute;
import com.nts.jvm.buff.Record;
import com.nts.jvm.constantpool.*;
import com.nts.jvm.fieldinfo.FieldInfo;
import com.nts.jvm.methodinfo.MethodInfo;
import com.nts.jvm.op.Instruction;
import com.nts.jvm.op.OpFactory;
import com.nts.jvm.tree.MethodTreeInfo;
import com.nts.jvm.util.AccessFlagsUtils;
import com.nts.jvm.util.ByteUtils;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassFile {

	// class文件
	// 类型 名称 数量
	// u4 magic 1
	// u2 minor_version 1
	// u2 major_version 1
	// u2 constant_pool_count 1
	// cp_info constant_pool constant_pool_count - 1
	// u2 access_flags 1
	// u2 this_class 1
	// u2 super_class 1
	// u2 interfaces_count 1
	// u2 interfaces interfaces_count
	// u2 fields_count 1
	// field_info fields fields_count
	// u2 methods_count 1
	// method_info methods methods_count
	// u2 attribute_count 1
	// attribute_info attributes attributes_count

	private int magic;

	private int minorVersion;

	private int majorVersion;

	public int getMagic() {
		return magic;
	}

	public void setMagic(int magic) {
		this.magic = magic;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}

	public int getConstantPoolCount() {
		return constantPoolCount;
	}

	public void setConstantPoolCount(int constantPoolCount) {
		this.constantPoolCount = constantPoolCount;
	}

	public HashMap<Integer, CP_info> getCpInfo() {
		return cpInfo;
	}

	public void setCpInfo(HashMap<Integer, CP_info> cpInfo) {
		this.cpInfo = cpInfo;
	}

	public int getAccessFlags() {
		return accessFlags;
	}

	public void setAccessFlags(int accessFlags) {
		this.accessFlags = accessFlags;
	}

	public int getThisClass() {
		return thisClass;
	}

	public void setThisClass(int thisClass) {
		this.thisClass = thisClass;
	}

	public int getSuperClass() {
		return superClass;
	}

	public void setSuperClass(int superClass) {
		this.superClass = superClass;
	}

	public int getInterfacesCount() {
		return interfacesCount;
	}

	public void setInterfacesCount(int interfacesCount) {
		this.interfacesCount = interfacesCount;
	}

	public int getFieldsCount() {
		return fieldsCount;
	}

	public void setFieldsCount(int fieldsCount) {
		this.fieldsCount = fieldsCount;
	}

	public ArrayList<FieldInfo> getFields() {
		return fields;
	}

	public void setFields(ArrayList<FieldInfo> fields) {
		this.fields = fields;
	}

	public int getMethodsCount() {
		return methodsCount;
	}

	public void setMethodsCount(int methodsCount) {
		this.methodsCount = methodsCount;
	}

	public ArrayList<MethodInfo> getMethods() {
		return methods;
	}


	public List<MethodTreeInfo> getMethodTree() {
		return treeInfoList;
	}

	public void setMethods(ArrayList<MethodInfo> methods) {
		this.methods = methods;
	}

	public int getAttributeCount() {
		return attributeCount;
	}

	public void setAttributeCount(int attributeCount) {
		this.attributeCount = attributeCount;
	}

	public ArrayList<AttributeInfo> getAttributes() {
		return attributes;
	}

	public void setAttributes(ArrayList<AttributeInfo> attributes) {
		this.attributes = attributes;
	}

	public ArrayList<Integer> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(ArrayList<Integer> interfaces) {
		this.interfaces = interfaces;
	}

	private int constantPoolCount;
	private HashMap<Integer, CP_info> cpInfo;
	private int accessFlags;
	private int thisClass;
	private int superClass;
	private int interfacesCount;
	private ArrayList<Integer> interfaces;
	private int fieldsCount;
	private ArrayList<FieldInfo> fields;
	private int methodsCount;
	private ArrayList<MethodInfo> methods;
	private int attributeCount;
	private ArrayList<AttributeInfo> attributes;

	private Map<String  ,Record> pcRecord;


	private String className = "";
	private List<MethodTreeInfo> treeInfoList = new ArrayList<MethodTreeInfo>();

	public String displayCode() {
		StringBuffer sb = new StringBuffer();
		treeInfoList.clear();

		String fullClassName = getPoolString(this.thisClass).replace("/", ".");
		int index = fullClassName.lastIndexOf(".");
		className = fullClassName;
		String packageName = "";
		if (index != -1) {
			className = fullClassName.substring(index + 1);
			packageName = fullClassName.substring(0, index);
		}
		if (packageName.length() > 0) {
			sb.append("package " + packageName + ";\n\n");
		}
		sb.append(AccessFlagsUtils.getCLassAccess(this.accessFlags));
		sb.append(" class " +className);
		sb.append("{\n");
		//show field
		sb.append("/****** fields ******/\n");
		for (int i = 0; i < fields.size(); i++) {
			FieldInfo fieldInfo = fields.get(i);
			fieldInfo.setCpInfoList(cpInfo);
			MethodTreeInfo info = new MethodTreeInfo(
					fieldInfo.getFieldName() , sb.length(),
					sb.length() + 1, 1);
			treeInfoList.add(info);
			sb.append("" + fieldInfo.displayCode() + "\n");
		}
		sb.append("\n\n/****** methods ******/\n");

		for (int i = 0; i < methods.size(); i++) {
			MethodInfo methodInfo = methods.get(i);
			methodInfo.setCpInfoList(cpInfo);
			int idx = sb.length() + 1;
			sb.append("\n" + methodInfo.getPrintName());

			MethodTreeInfo info = new MethodTreeInfo(methodInfo.getName(), idx,
					idx + methodInfo.getPrintName().length(), 2);
			treeInfoList.add(info);

			sb.append("{\n");
			AttributeInfo[] attributeInfo = methodInfo.getAttributes();
			if (attributeInfo != null) {
				for (AttributeInfo att : attributeInfo) {
					att.setCpInfoList(cpInfo);
					att = AttributeInfoFactory.getAttribute(cpInfo, att);
					if (att instanceof Code_attribute) {
						Code_attribute a = (Code_attribute) att;
						a.setCpInfoList(cpInfo);
						sb.append(readCode(a.getCode()) + "\n");
					}
				}
			}
			sb.append("}\n");
		}
		sb.append("\n}");
		return sb.toString();
	}

	public String getCLassName() {
		return className;
	}

	public Map<String, Record> getPcRecord(){
		return  pcRecord;
	}
	/**
	 * @param code
	 * @return
	 */
	public   String readCode(byte[] code) {
		int pc = 0;
		int sz = code.length;

		StringBuilder sb = new StringBuilder();
		Map<Integer, Instruction> instionList= OpFactory.instionList;
		while (pc < sz) {
			try {
				int codeId = Byte.toUnsignedInt(code[pc]);
				Instruction instruction = instionList.get(codeId);
				if (instruction != null) {
					int newPc = instruction.read(code, pc);
					String extInfo="";
					if(instruction.getIndex()>0){
						extInfo="\t"+getString(instruction.getIndex());
					}

					sb.append("\t\t"+pc + " " + instruction +  extInfo +" \n");
					//System.out.println(pc + ">>" + instruction);
					if (newPc == pc) {
						// System.out.println(toErrorCode(code));
						throw new RuntimeException(ByteUtils.toHex(codeId) + " >> 格式错误");
					}
					pc = newPc;
				} else {
					//System.out.println(toErrorCode(code));
					throw new RuntimeException(ByteUtils.toHex(codeId) + " >> 格式错误");
				}
			}catch (Exception ex){
				//System.out.println(toErrorCode(code));
				throw ex;
			}

		}

		return sb.toString();
	}




	@Override
	public String toString() {

		// class文件
		// 类型 名称 数量
		// u4 magic 1
		// u2 minor_version 1
		// u2 major_version 1
		// u2 constant_pool_count 1
		// cp_info constant_pool constant_pool_count - 1
		// u2 access_flags 1
		// u2 this_class 1
		// u2 super_class 1
		// u2 interfaces_count 1
		// u2 interfaces interfaces_count
		// u2 fields_count 1
		// field_info fields fields_count
		// u2 methods_count 1
		// method_info methods methods_count
		// u2 attribute_count 1
		// attribute_info attributes attributes_count

		StringBuffer sb = new StringBuffer();
		ByteBuffer magicBuff = ByteBuffer.allocate(4);
		magicBuff.putInt(magic);
		magicBuff.flip();
		String strMagic = "";
		for (int i = 0; i < 4; i++) {
			String c = ByteUtils.hex(magicBuff.get());
			strMagic += c;
		}
		strMagic = strMagic.replace("0x", "");

		sb.append("magic:" + strMagic + "\n");
		sb.append("minor_version:" + minorVersion + "\n");
		sb.append("major_version:" + majorVersion + "\n");
		sb.append("constant_pool_count:" + constantPoolCount + "\n");
		sb.append("     (\n");

		for (int i = 1; i <= cpInfo.size(); i++) {
			if (cpInfo.get(i) != null)
				sb.append("     #" + i + "=" +  formatCpInfo(cpInfo.get(i)) + "\n");
		}

		sb.append("     )\n\n");

		sb.append("access_flags:" + accessFlags + "\n");
		sb.append("this_class:" + thisClass + "\n");
		sb.append("super_class:" + superClass + "\n");
		sb.append("interfaces_count:" + interfacesCount + "\n");
		sb.append("interfaces:\n{\n");
		for (int i = 0; i < interfaces.size(); i++) {
			sb.append("         " + interfaces.get(i) + "\n");
		}
		sb.append(" }\n");
		sb.append("fields_count:" + fieldsCount + "\n");
		sb.append("field_info:   \n");
		sb.append("     (\n");
		for (int i = 0; i < fields.size(); i++) {
			sb.append("         " + fields.get(i) + "\n");
		}
		sb.append("     )\n");
		sb.append("methods_count:" + methodsCount + "\n");
		sb.append("method_info: \n( \n");
		for (int i = 0; i < methods.size(); i++) {
			sb.append("     " + methods.get(i) + "\n");
		}
		sb.append(" )\n");
		sb.append("attribute_count:" + attributeCount + "\n");
		sb.append("attribute_info: \n(\n");
		for (int i = 0; i < attributes.size(); i++) {
			sb.append("         " + attributes.get(i) + "\n");
		}
		sb.append("     \n)\n");
		return sb.toString();

	}

	public void setPcRecord(Map<String, Record> recordMap) {
		this.pcRecord=recordMap;
	}




	public   String getPoolString(int index) {
		return getString(index);
	}


	public  String formatCpInfo(CP_info info) {
		return formatCpInfo(info, true);
	}

	/**
	 * @param info
	 * @return
	 */
	public   String formatCpInfo(CP_info info, boolean debug) {
		int tag = info.getTag();

		switch (tag) {
			case 1: {
				CONSTANT_Utf8_info classInfo = (CONSTANT_Utf8_info) info;
				return "Utf8  " + classInfo.getUtf8();
			}
			case 3: {
				CONSTANT_Integer_info classInfo = (CONSTANT_Integer_info) info;
				return "Integer ";
			}
			case 4: {
				CONSTANT_Float_info classInfo = (CONSTANT_Float_info) info;
				return "Float ";
			}

			case 5: {
				CONSTANT_Long_info classInfo = (CONSTANT_Long_info) info;
				return "Long";
			}
			case 6: {

				CONSTANT_Double_info classInfo = (CONSTANT_Double_info) info;
				return "Double ";
			}
			case 7: {
				CONSTANT_Class_info classInfo = (CONSTANT_Class_info) info;
				return (debug ? (
						"Class #" + classInfo.getNameIndex()
								+ " // ") : "")

						+ getString(classInfo.getNameIndex());
			}

			case 8: {
				CONSTANT_String_info classInfo = (CONSTANT_String_info) info;
				return (debug ? ("String #" + classInfo.getStringIndex() + " // ") : "")
						+ getString(classInfo.getStringIndex());
			}
			case 9: {
				CONSTANT_Fieldref_info classInfo = (CONSTANT_Fieldref_info) info;
				return
						(debug ? (
								"Fieldref #" + classInfo.getClassIndex() + " // ") : ""
						)
								+
								getString(classInfo.getClassIndex()) +":"+getString(classInfo.getNameAndTypeIndex());
			}

			case 10: {
				CONSTANT_Methodref_info classInfo = (CONSTANT_Methodref_info) info;
				return (debug ? (
						"Methodref #" + classInfo.getClassIndex() + ".#" +
								classInfo.getNameAndTypeIndex()
								+ " // "
				) : "")
						+ getString(classInfo.getClassIndex())
						+ ":" + getString(classInfo.getNameAndTypeIndex())
						;
			}

			case 11: {
				CONSTANT_InterfaceMethodref_info classInfo = (CONSTANT_InterfaceMethodref_info) info;
				return
						debug ? (
								"InterfaceMethodref #" + classInfo.getClassIndex() + ".#" +
										classInfo.getNameAndTypeIndex()
										+ " // "
						) : ""

								+ getString(classInfo.getClassIndex())
								+ ":" + getString(classInfo.getNameAndTypeIndex())
						;
			}

			case 12: {
				CONSTANT_NameAndType_info classInfo = (CONSTANT_NameAndType_info) info;
				return
						(debug ? (
								"NameAndType #" + classInfo.getNameIndex() + ".#" +
										classInfo.getDescriptorIndex()
										+ " // "
						) : ""
						)
								+ getString(classInfo.getNameIndex())
								+ ":" + getString(classInfo.getDescriptorIndex())
						;
			}

			case 15: {
				CONSTANT_MethodHandle_info classInfo = (CONSTANT_MethodHandle_info) info;
				return
						(debug ? (
								"MethodHandle #" + classInfo.getReferenceKind() + ".#" +
										classInfo.getReferenceIndex()
										+ " // "

						) : ""
						)
								+ getString(classInfo.getReferenceKind())
								+ ":" + getString(classInfo.getReferenceIndex())
						;
			}

			case 16: {
				CONSTANT_MethodType_info classInfo = (CONSTANT_MethodType_info) info;
				return (debug ? (

						"MethodType  #" + classInfo.getDescriptorIndex()
								+ " // "
				) : ""
				)
						+ " " + getString(classInfo.getDescriptorIndex())
						;
			}


			case 18: {
				CONSTANT_InvokeDynamic_info classInfo = (CONSTANT_InvokeDynamic_info) info;
				return
						(debug ? (
								"InvokeDynamic #" + classInfo.getBootStrapMethodAttrIndex()
										+ ".#" +
										classInfo.getNameAndTypeIndex()
										+ " // "
						) : ""
						)
								+ getString(classInfo.getBootStrapMethodAttrIndex())
								+ ":" + getString(classInfo.getNameAndTypeIndex())
						;
			}


			default:
				return "";

		}

	}


	public   String getString(int index) {
		return getString(index, 0);
	}

	/**
	 * @param index
	 * @return
	 */

	private   String getString(int index, int level) {
		level++;
		if (level >= 5) return "";
		CP_info cp = cpInfo.get(index);
		if (cp instanceof CONSTANT_Utf8_info) {
			return ((CONSTANT_Utf8_info) cp).getUtf8();
		} else {
			if (cp == null) {
				return "";
			}
			return formatCpInfo(cp, false);

		}
	}

	public   Number getNumber(int index) {
		CP_info info = cpInfo.get(index);
		if (info == null) {
			return -1;
		}
		int tag = info.getTag();

		switch (tag) {
			case 3: {
				CONSTANT_Integer_info classInfo = (CONSTANT_Integer_info) info;
				return classInfo.getIntergerInfo();
			}
			case 4: {
				CONSTANT_Float_info classInfo = (CONSTANT_Float_info) info;
				return classInfo.getFloatInfo();
			}

			case 5: {
				CONSTANT_Long_info classInfo = (CONSTANT_Long_info) info;
				return classInfo.getIntergerInfo();
			}
			default:
				return 0;
		}
	}
}
