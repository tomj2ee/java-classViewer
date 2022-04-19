package com.nts.jvm.buff;

public class  Record {

	public int startPc;
	public int endPc;

	public Record(int p1, int p2) {
		this.startPc = p1;
		this.endPc = p2;
	}

}