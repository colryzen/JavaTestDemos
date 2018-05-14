package com.example.math;

public class mathTest {
	public static void main(String[] args) {
		// System.out.println("math 宽度："+ MathHelper.roundUp(1));
		// System.out.println("math 宽度："+ MathHelper.roundUp(15));
		System.out.println("math 宽度：" + MathHelper.roundUp(199));
		System.out.println(MathHelper.roundUp1or5(1.1));

		System.out.println("整数 floor：" + Math.floor(5.5));
		System.out.println("整数 floor：" + Math.floor(-5.5));
		System.out.println("整数 ceil：" + Math.ceil(5.5));
		System.out.println("整数 ceil：" + Math.ceil(-5.5));
		System.out.println("整数 round=" + Math.round(-5.6));
		System.out.println("整数 round=" + Math.round(5.5));

		int exponent = (int) Math.floor(Math.log10(105));
		System.out.println("指数=" + exponent);
		
		test();
		
	}

	private static void test() {
		System.out.println("十转二：" + Integer.toBinaryString(120));
		System.out.println("十转八：" + Integer.toOctalString(120));
		System.out.println("十转十六：" + Integer.toHexString(12));
		System.out.println("二转十：" + Integer.valueOf("1010", 2));
		System.out.println("八转十：" + Integer.valueOf("125", 8));
		System.out.println("十六转十：" + Integer.valueOf("ABCDEF", 16));
	}

}
