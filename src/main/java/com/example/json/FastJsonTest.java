package com.example.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class FastJsonTest {

    public static void main(String[] args) {

        String a="w01001";
        String b="W01001";
        System.out.println("a=b"+ a.equalsIgnoreCase(b));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id","001");
        jsonObject.put("PH","nw");
        jsonObject.put("TP","001");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("id","001");
        jsonObject2.put("COD","5");
        jsonObject2.put("O2","09");


        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("id","002");
        jsonObject3.put("COD","2");
        jsonObject3.put("O2","88");

        ArrayList<JSONObject>  list =new ArrayList<>();
        list.add(jsonObject);
        list.add(jsonObject2);
        list.add(jsonObject3);




        System.out.println( mergeDataIfConflict(list,"id"));

    }

    /**
     *
     * 合并 conflickey字段值相同的 json
     *
     * @param jsonList
     * @param conflictKey  检查键
     * @return 合并后的数据
     */

    protected  static ArrayList<JSONObject> mergeDataIfConflict(List<JSONObject> jsonList, String conflictKey){
        HashMap<String,JSONObject> mapList=new HashMap<>();
        ArrayList<JSONObject>  resultList= new ArrayList<>();
        for(JSONObject jsonObject: jsonList){
            Object  conflictValue=  jsonObject.get(conflictKey);
            if(conflictValue==null){
                resultList.add(jsonObject);
                continue;
            }
            JSONObject jsonExit= mapList.get(conflictValue.toString());
            if(jsonExit==null){
                mapList.put(conflictValue.toString(),jsonObject);
            }else{
                Set<String> keySet=  jsonObject.keySet();
                for(String key :keySet){
                    jsonExit.put(key,jsonObject.get(key));
                }
            }
        }
        resultList.addAll(mapList.values());
        return  resultList;
    }

}
