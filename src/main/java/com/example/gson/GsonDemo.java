package com.example.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonDemo {
    public static void main(String[] args) {
    	 Gson gson=new GsonBuilder().setLenient()// json宽松
        .enableComplexMapKeySerialization()//支持Map的key为复杂对象的形式  
        .serializeNulls() //智能null  
        .setPrettyPrinting()// 调教格式  
        .disableHtmlEscaping()
        .create();//默认是GSON把HTML 转义的  
    	
    	String  jsonStr="{\"STATU\":\"success\",\"RESULT\":\"\",\"MESSAGE\":\"\"}";
//    	TaskEntriy taskEntriy= gson.fromJson(jsonStr, TaskEntriy.class);
//    	System.out.println("statu="+ taskEntriy.getSTATU());
    	
    	String employeesStr="{\"id\":1,\"name\":\"汤成锋\",\"username\":\"18965910111\",\"pyshortname\":\"tcf\",\"pysortkey\":\"tang汤cheng成feng锋\",\"pyname\":\"tangchengfeng\",\"t9code\":\"8264,24364,3364\",\"t9shortcode\":\"823\",\"gender\":0,\"email\":\"tcf@strongsoft.net\",\"mobile\":\"18965910111,87649888\",\"address\":null,\"bio\":\"高度决定长度，格局决定大小\",\"lasttm\":\"2016-08-01T17:36:38\",\"avatar\":null,\"state\":null,\"postcode\":\"350100\",\"chinesecode\":\"福建省-福州市\"}";
    	
    	Gson gson2=new GsonBuilder().serializeNulls().create();
    	EmployeesEntriy employeesEntriy= gson2.fromJson(employeesStr, EmployeesEntriy.class);
    	System.out.println("statu="+ employeesEntriy.getName());
    	
    //	System.out.println("id="+  taskEntriy.getID() + ",L_ID" + taskEntriy.getL_ID()+" name="+taskEntriy.getNAME());
    	
	}
}
