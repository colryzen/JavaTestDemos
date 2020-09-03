package com.example.base;




import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class a {
    public static void main(String[] args) {
          sss();
    }

    public static void sss(){
        long l = System.currentTimeMillis();
        //--查询各区县有多少学校
        List<Map> schoolTotalList = new ArrayList<>();
        String kkk = "南平市,延平区";
        List<String> strings = Arrays.asList(kkk.split(","));
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(makeJson("学前"));
//        jsonArray.add(makeJson("小学"));
//        jsonArray.add(makeJson("初中"));
//        jsonArray.add(makeJson("高中"));
//        jsonArray.add(makeJson("中职"));
//        jsonArray.add(makeJson("本专科"));
        System.out.print("firstStep===========:"+jsonArray);
        final  int  length=jsonArray.length();
        for(int i=0;i<length;i++){
            JSONObject jsonObject = (JSONObject) jsonArray.optJSONObject(i);
            try {
                jsonObject.put("schoolTotal",8);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        System.out.println("secondStep========:"+jsonArray);

        JSONArray list = new JSONArray();
        for(String s:strings){
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("area",s);
                jsonObject.put("schoolTotal",16);
                jsonObject.put("list",jsonArray);
                list.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        System.out.println("原始数据："+list);
//        JSONObject jsonObject = list.getJSONObject(0);
//        System.out.println(jsonObject);
//        JSONArray list1 = jsonObject.getJSONArray("list");
//        System.out.println(list1);
//        JSONObject jsonObject7 = list1.getJSONObject(0);
//
////        jsonObject7.put("schoolTotal",8);
////        jsonObject7.put("schoolTotals",8);
//        Object schoolTotal = jsonObject7.replace("schoolTotal", 8);
//        System.out.println(jsonObject7);
//        log.info("object:{}",schoolTotal);
//        System.out.println(list);
    }


    public static JSONObject makeJson(String degree){
        JSONObject jsonObject1 = new JSONObject();
        try {
            jsonObject1.put("degree",degree);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject1;
    }
}
