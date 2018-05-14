package com.example.math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRgs {

	public static void main(String[] args) {
		System.out.println(isPhone("15712344321"));
		String  a16=Integer.toHexString(25);
		System.out.println("16hex="+a16);
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
