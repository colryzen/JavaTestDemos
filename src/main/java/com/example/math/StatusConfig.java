package com.example.math;

import java.util.HashMap;

import org.json.JSONObject;
/**
 * 
 * @author rkr
 *
 */
public class StatusConfig {

	/** 主任 */
	public static final int STATUS_ZR = 1;
	/** 维护任务单 */
	public static final int STATUS_WHRWD = 2;
	/** 维护记录单 */
	public static final int STATUS_WHJLD = 3;
	/** 是否解决 */
	public static final int STATUS_SOLVE = 4;

	// 角色类型，角色表示 111，第一位表示主任，第二位表示值班人员，第三位表示检查人员
	/** 权限掩码 */
	public static final int AUTHMARKS = 0x7;
	public static final int IS_ZR = 0x1; // 主任 001
	public static final int IS_ZBRY = 0x2; // 值班人员 010
	public static final int IS_JXRY = 0x4; // 检查人员，维修人员 100

	/***/
	public static HashMap<Integer, Integer> STATUS_ROLE_MAP = new HashMap<Integer, Integer>();
	static {
		// 主任审核--主任
		STATUS_ROLE_MAP.put(STATUS_ZR, IS_ZR);
		// 维护任务单--值班人员
		STATUS_ROLE_MAP.put(STATUS_WHRWD, IS_ZBRY);
		// 维护记录单--检查人员
		STATUS_ROLE_MAP.put(STATUS_WHJLD, IS_JXRY);
		// 是否解决--值班人员
		STATUS_ROLE_MAP.put(STATUS_SOLVE, IS_ZBRY);
	}

	/**
	 * 判断用户是否有对应的权限
	 * 
	 * @param status
	 *            当前状态
	 * @param usrAuthmarks
	 *            用户有的全部权限
	 * @return
	 */
	public static boolean checkAuth(int status, int usrAuthmarks) {
		// 关联当前状态对应的处理角色
		int role = STATUS_ROLE_MAP.get(status);
		// 判断当前用户是否有权限
		int result = role & usrAuthmarks;
		return result > 0;
	}

	/**
	 * 获取用户权限,将用户所有的权限转换成一个INT 类型数字表示
	 */
	public static int getUserAuth(JSONObject jsonObj) {
		boolean is_jxry = false; // 检查人员
		boolean is_zr = false; // 主任
		boolean is_zbry = false; // 值班人员
		int allAuth = 0; // 用户所有的权限，模仿linux 文件权限表示方法
		if (jsonObj != null) {
			is_jxry = jsonObj.optInt("IS_JXRY", -1) == 1 ? true : false;
			is_zbry = jsonObj.optInt("IS_ZBRY", -1) == 1 ? true : false;
			is_zr = jsonObj.optInt("IS_ZR", -1) == 1 ? true : false;
		}
		allAuth = is_jxry == true ? IS_JXRY & AUTHMARKS | allAuth : allAuth;
		allAuth = is_zbry == true ? IS_ZBRY & AUTHMARKS | allAuth : allAuth;
		allAuth = is_zr == true ? IS_ZR & AUTHMARKS | allAuth : allAuth;
		return allAuth;
	}
	
	
	public static void main(String[] args) {
		int result = 0x1 &7;
		System.out.println(result);
		System.out.println(0x1<<2);
	}
	
}
