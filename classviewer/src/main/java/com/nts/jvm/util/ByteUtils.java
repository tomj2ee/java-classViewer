package com.nts.jvm.util;


public class ByteUtils {

	/**
	 * 
	 * @param bytes
	 * @param len
	 * @return
	 */
	private static int getInt(byte[] bytes, int len) {
		int ret = 0;
		for (int i = len - 1; i >= 0; i--) {
			int c = (int)bytes[i] & 0xff;
			int l1 = c >> 4 & 0xf;
			int l2 = c & 0xf;
			int j = 2 * (len - 1 - i);
			ret += l1 * (int) Math.pow(16, j + 1) + l2 * (int) Math.pow(16, j);
		}
		return ret;
	}

	public static long getInt8(byte[] bytes) {
		long ret = 0;
		for (int i = 7; i >= 0; i--) {
			int c = (int)bytes[i] & 0xff;
			int l1 = c >> 4 & 0xf;
			int l2 = c & 0xf;
			int j = 2 * (7 - i);
			ret += l1 *  Math.pow(16, j + 1) + l2 *  Math.pow(16, j);
		}
		return ret;
	}

	/**
	 * 
	 * @param bytes
	 * @return
	 */
	public static int getInt4(byte[] bytes) {
		return getInt(bytes, 4);
	}

	/**
	 * 
	 * @param bytes
	 * @return
	 */
	public static int getInt2(byte[] bytes) {
		return getInt(bytes, 2);
	}


	public static  String hex(byte b){
		String ret=   Integer.toHexString(b).replace("ffffff","");
		if(ret.length()==1){
			ret="0"+ret;
		}

		return "0x"+ret;
	}

	/**
	 * 
	 * @param bytes
	 * @return
	 */

	public static int getInt1(byte[] bytes) {
		return getInt(bytes, 1);
	}

	public static int getInt1(byte b) {
		int l1 = b >> 4 & 0x0f;
		int l2 = b & 0x0f;
		return l1 * 16 + l2;
	}

	public static String toHex(byte b) {
		String ret=   Integer.toHexString(b).replace("ffffff","");
		if(ret.length()==1){
			ret="0"+ret;
		}
		return  ret;
	}


	public static String toHex(int b) {
		String ret=   Integer.toHexString(b).replace("ffffff","");
		if(ret.length()==1){
			ret="0"+ret;
		}
		return  ret;
	}
}
