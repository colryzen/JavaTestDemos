package com.example.math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRgs {

	public static void main(String[] args) {
		System.out.println(isPhone("15712344321"));
		String  a16=Integer.toHexString(25);
		System.out.println("16hex="+a16);

        String rex="([0-9]+)";

		Pattern p = Pattern.compile(rex);
		Matcher matcher = p.matcher("123abc456def");
		System.out.println("matcher count="+matcher.groupCount());
		while (matcher.find()){
			String r=matcher.group();
			System.out.println("matcher r="+r);
		}

	    final String rex2="([a-z]+)(\\d+)";

		Pattern p2 = Pattern.compile(rex2);
		Matcher m = p2.matcher("java265.com");
		System.out.println("find="+m.find()); // 匹配java265
		System.out.println("groupCount="+m.groupCount()); // 返回2,因为有2组
		System.out.println(m.start(1)); // 返回0 返回第一组匹配到的子字符串在字符串中的索引号
		System.out.println(m.start(2)); // 返回4
		System.out.println(m.end(1)); // 返回4 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
		System.out.println(m.end(2)); // 返回7
		System.out.println(m.group(1)); // 返回java,返回第一组匹配到的子字符串
		System.out.println(m.group(2)); // 返回265,返回第二组匹配到的子字符串

	}
	
	
	/**移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
	 * 联通：130、131、132、152、155、156、185、186
	 * 电信：133、153、180、189
	 * 虚拟：170号
	 * @param phone
	 * @return
	 */
	public static boolean isPhone(String phone){
		String regExp = "^[1](3|5|7|8){1}[0-9]{9}$";
		Pattern p = Pattern.compile(regExp);
		Matcher matcher = p.matcher(phone);
		if(matcher.find()){
			return true;
		}	
		return false;
	}

}
