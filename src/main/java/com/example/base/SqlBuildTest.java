package com.example.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.tools.javac.util.StringUtils;

import java.util.Set;

public class SqlBuildTest {

   public static  String json = " {\n" +
           "            \"REC_ID\": 683,\n" +
           "            \"RECDATE\": \"2008-02-01\",\n" +
           "            \"ITEM_CODE\": \"0019\",\n" +
           "            \"ITEMNAME\": \"氰化物\",\n" +
           "            \"THETYPE\": null,\n" +
           "            \"CHECKVALUE\": -1\n" +
           "        }";



   public  static String formJson=" [\n" +
           "{\n" +
           "\"count\": 91,\n" +
           "\"ITEM_CODE\": \"0001\",\n" +
           "\"ITEMNAME\": \"水温\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 90,\n" +
           "\"ITEM_CODE\": \"0002\",\n" +
           "\"ITEMNAME\": \"pH\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 91,\n" +
           "\"ITEM_CODE\": \"0003\",\n" +
           "\"ITEMNAME\": \"溶解氧\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 90,\n" +
           "\"ITEM_CODE\": \"0004\",\n" +
           "\"ITEMNAME\": \"高锰酸盐指数\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 90,\n" +
           "\"ITEM_CODE\": \"0006\",\n" +
           "\"ITEMNAME\": \"五日生化需氧量\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 91,\n" +
           "\"ITEM_CODE\": \"0007\",\n" +
           "\"ITEMNAME\": \"氨氮\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 90,\n" +
           "\"ITEM_CODE\": \"0008\",\n" +
           "\"ITEMNAME\": \"总磷\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 90,\n" +
           "\"ITEM_CODE\": \"0009\",\n" +
           "\"ITEMNAME\": \"总氮\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0010\",\n" +
           "\"ITEMNAME\": \"铜\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0011\",\n" +
           "\"ITEMNAME\": \"锌\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0012\",\n" +
           "\"ITEMNAME\": \"氟化物\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0013\",\n" +
           "\"ITEMNAME\": \"硒\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0014\",\n" +
           "\"ITEMNAME\": \"砷\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0015\",\n" +
           "\"ITEMNAME\": \"汞\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0016\",\n" +
           "\"ITEMNAME\": \"镉\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0017\",\n" +
           "\"ITEMNAME\": \"铬\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0018\",\n" +
           "\"ITEMNAME\": \"铅\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0019\",\n" +
           "\"ITEMNAME\": \"氰化物\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0020\",\n" +
           "\"ITEMNAME\": \"挥发酚\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0021\",\n" +
           "\"ITEMNAME\": \"石油类\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0022\",\n" +
           "\"ITEMNAME\": \"阴离子表面活性剂\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0023\",\n" +
           "\"ITEMNAME\": \"硫化物\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0024\",\n" +
           "\"ITEMNAME\": \"粪大肠菌群\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0025\",\n" +
           "\"ITEMNAME\": \"硫酸盐\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 88,\n" +
           "\"ITEM_CODE\": \"0026\",\n" +
           "\"ITEMNAME\": \"氯化物\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 88,\n" +
           "\"ITEM_CODE\": \"0027\",\n" +
           "\"ITEMNAME\": \"硝酸盐\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 88,\n" +
           "\"ITEM_CODE\": \"0028\",\n" +
           "\"ITEMNAME\": \"铁\"\n" +
           "},\n" +
           "{\n" +
           "\"count\": 89,\n" +
           "\"ITEM_CODE\": \"0029\",\n" +
           "\"ITEMNAME\": \"锰\"\n" +
           "}\n" +
           "]";

    public static void main(String[] args) {

         JSONObject jsonObject = JSON.parseObject(json);
        // System.out.println("jsonObj="+jsonObject.toJSONString());

         Set<String> keySet= jsonObject.keySet();

         StringBuffer stringBuffer = new StringBuffer();

         for(String key :keySet){
             stringBuffer.append(" \"").append(key).append("\" text ,");
         }

      //   System.out.println( stringBuffer.toString());

         String fromateStr="('402883896458dc8f0164d48d14776fbd', '0107', 'ITEM_CODE', 'value', 'WE_WaterIntakeData', 'monitorCityCode', 'table', '%1$s', “%2$s”)";

        JSONArray jsonArray =JSONArray.parseArray(formJson);


        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject1= jsonArray.getJSONObject(i);
            System.out.println(String.format(fromateStr,jsonObject1.getString("ITEMNAME"),jsonObject1.getString("ITEM_CODE")));
        }
    }


}