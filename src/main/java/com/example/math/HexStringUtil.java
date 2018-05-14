package com.example.math;


/**
 * 十六进制转换
 * 
 * @author Administrator
 *
 */

public class HexStringUtil {

	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);

			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * 十六进制转 byte[]
	 * 
	 * @param 十六进制字符串
	 * @return byte[]
	 */
	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	/**
	 * Convert char to byte
	 * 
	 * @param c
	 *            char
	 * @return byte
	 */
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}


	public static byte intToByte(int iSource) {
		return (byte) (iSource & 0xFF);
	}

	 public static int byteToInt(byte b) {
		return b & 0xFF;
	}
	
	/**
	 * byte转int
	 * 
	 * <p>
	 * 说明：
	 * 字节数组的低位是整型的高位字节位
	 * 如   bytes {0,0,0,40} =40
	 * <p>
	 * 
	 * @param bRefArr
	 * @return
	 */
	public static int bytesToInt(byte[] bRefArr) {
		int iOutcome = 0;
		byte bLoop;
		final int lenth = bRefArr.length;
		for (int i = 0; i < lenth; i++) {
			bLoop = bRefArr[lenth -1- i];
			iOutcome += (bLoop & 0xFF) << (8 * i);
		}
		return iOutcome;
	}

	
	/**
	 * int转byte
	 * <p>
	 * 说明：
	 * 字节数组的低位是整型的高位字节位
	 * 如   bytes 40 ={0,0,0,40} 
	 * <p>
	 * @param iSource
	 * @param iArrayLen
	 * @return
	 */
	public static byte[] intToByteArray(int iSource, int iArrayLen) {
		byte[] bLocalArr = new byte[iArrayLen];
		for (int i = 0; i < iArrayLen; i++) {
			//高位
			bLocalArr[iArrayLen-1- i] = (byte) (iSource >> (8 * i) & 0xFF);
		}
		return bLocalArr;
	}
	

	public static byte[] byteCut(byte[]bytedata,int position,int lenth){
		byte [] byteresult = new byte[lenth];
		System.arraycopy(bytedata, position, byteresult, 0, lenth);
		return byteresult;
	}
	
	
	/**
	 * 合并多个byte数组
	 * @param byteArrays
	 * @return
	 */
	public static byte[] mergeByteArrays(byte[]... byteArrays ){
		int length=0;
		for(int i =0;i<byteArrays.length;i++){
			length+=byteArrays[i].length;
		}
		int position=0;
		byte[] result =new byte[length];
		for(int i =0;i<byteArrays.length;i++){
			System.arraycopy(byteArrays[i], 0, result, position, byteArrays[i].length);
			position+=byteArrays[i].length;
		}
		return result;
	}
	
	
	/**
	 * 打印字节数据
	 * @param srcBytes
	 * @return
	 */
	public static String printBytes(byte[] srcBytes) {
		StringBuffer strBuf = new StringBuffer();
		final int length = srcBytes.length;
		for (int i = 0; i < length; i++) {
			strBuf.append((int)(srcBytes[i])+",");
		}
		return strBuf.toString();
	}
	
	
	public static void main(String[] args) {
		byte[] testByte = { 0, 0,0,-1 };
		byte[] testByte2 = { 1, 2 };
		byte[] testByte3 = { 3, 4 };
		String byteStr = bytesToHexString(testByte);
		System.out.println("bytesToHexString= " + byteStr);
		byte[] result = hexStringToBytes(byteStr);
		System.out.println(result[0] + "," + result[1]);
		System.out.println("byte to int ="
				+ HexStringUtil.bytesToInt(new byte[] { 0, 0, 0, 40}));
		System.out.println("bytes to int ="
				+ HexStringUtil.printBytes(HexStringUtil.intToByteArray(255, 4)));
		
		
		System.out.println("bytearrays merge ="
				+ HexStringUtil.printBytes(HexStringUtil.mergeByteArrays(testByte,testByte2,testByte3)));
		
		String hexDate="200000000e00000155b4e8c64f0c000203008003e8000005";
		byte[] hexDaetBytes = hexStringToBytes(hexDate);
		System.out.println(hexDate+"转换结果："+ HexStringUtil.printBytes(hexDaetBytes));
		
	}
	
}
