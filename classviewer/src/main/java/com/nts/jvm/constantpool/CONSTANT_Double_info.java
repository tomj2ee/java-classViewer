package com.nts.jvm.constantpool;


import java.util.ArrayList;

public class CONSTANT_Double_info extends CONSTANT_Long_info {

	 
	// u1 tag CONSTANT_Double(6)
	// u4 high_bytes 双精度浮点的高四位值
	// u4 low_bytes 双精度浮点的低四位值
	public int getTag() {
		return 6;
	}

	@Override
	public void readContent() throws Exception {

		super.readContent();

	}


	@Override
	public String toString() {

		return "CONSTANT_Double_info [tag=" + tag + "   ]";
	}

}
