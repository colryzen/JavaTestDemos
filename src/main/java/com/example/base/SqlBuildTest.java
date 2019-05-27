package com.example.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.util.StringKeyChangeTool;
import com.sun.tools.javac.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class SqlBuildTest {

   public static  String json = "   {\n" +
           "            \"DIRECTION\": null,\n" +
           "            \"RIVER_\": null,\n" +
           "            \"BOILER_TYPE\": \"\",\n" +
           "            \"REPORT_STOP\": \"0\",\n" +
           "            \"LATITUDE\": null,\n" +
           "            \"ALLOW_PLU_LET\": null,\n" +
           "            \"PE_ID\": 4724,\n" +
           "            \"SEQ_NO\": null,\n" +
           "            \"SYMBOL_STYLE\": null,\n" +
           "            \"PWD\": null,\n" +
           "            \"IS_CITY_CONCERNED\": \"0\",\n" +
           "            \"CONTACT_NUM\": null,\n" +
           "            \"IS_PUT_HOUR\": null,\n" +
           "            \"GAF_TYPE_CODE\": null,\n" +
           "            \"CSN\": \"3507211030011A\",\n" +
           "            \"HIDDEN_OUTPUT\": \"1\",\n" +
           "            \"CODE\": null,\n" +
           "            \"SINGLE_OUTPUT\": \"\",\n" +
           "            \"NAME\": \"忠跃畜牧发展有限公司\",\n" +
           "            \"OUTPUT_ID\": 90,\n" +
           "            \"FUEL_CODE\": null,\n" +
           "            \"PRODUCT\": null,\n" +
           "            \"UPDATE_TIME\": null,\n" +
           "            \"ACTUAL_DAILY_CAPACITY\": null,\n" +
           "            \"IS_PUT_MIN\": null,\n" +
           "            \"UPDATE_USER_ID\": null,\n" +
           "            \"OUTFALL_TYPE\": \"1\",\n" +
           "            \"GOR_CODE\": null,\n" +
           "            \"UNIT_TRANSLATE\": 1,\n" +
           "            \"OPERATOR\": null,\n" +
           "            \"STATUS\": \"1\",\n" +
           "            \"ETONG_TRAN\": \"0\",\n" +
           "            \"SITE_TYPE\": null,\n" +
           "            \"INSERT_USER_ID\": null,\n" +
           "            \"PORT\": null,\n" +
           "            \"AIR_COEFFICIENT\": 1,\n" +
           "            \"IS_PUT_DAILY\": null,\n" +
           "            \"BURN_CODE\": null,\n" +
           "            \"IP_ADDRESS\": null,\n" +
           "            \"DOWN_TRAN\": \"0\",\n" +
           "            \"INSERT_TIME\": null,\n" +
           "            \"STOCK_SHOW\": \"0\",\n" +
           "            \"ENABLE_STATUS\": \"1\",\n" +
           "            \"ISEXPORT\": 0,\n" +
           "            \"CONTACT\": null,\n" +
           "            \"UP_TRAN\": \"0\",\n" +
           "            \"IS_AREA_CONCERNED\": \"1\",\n" +
           "            \"IS_PROVINCE_CONCERNED\": \"0\",\n" +
           "            \"CYC\": 5,\n" +
           "            \"POS_\": null,\n" +
           "            \"FIRST_UPLOAD_DATA\": null,\n" +
           "            \"LONGITUDE\": null,\n" +
           "            \"LICENCE_CODE\": null\n" +
           "        } ";



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



        ArrayList<String>  arrayList =new ArrayList<>();


         JSONObject jsonObject = JSON.parseObject(json);
        // System.out.println("jsonObj="+jsonObject.toJSONString());

         Set<String> keySet= jsonObject.keySet();

         StringBuffer stringBuffer = new StringBuffer();

         for(String key :keySet){
             // String jsonKey= StringKeyChangeTool.lineToHump(key);
             String jsonKey= key;
             stringBuffer.append(" \"").append(jsonKey).append("\" text ,");
         }

         System.out.println( stringBuffer.toString());

         String fromateStr="('402883896458dc8f0164d48d14776fbd', '0107', 'ITEM_CODE', 'value', 'WE_WaterIntakeData', 'monitorCityCode', 'table', '%1$s', “%2$s”)";

         JSONArray jsonArray =JSONArray.parseArray(formJson);


//        for(int i=0;i<jsonArray.size();i++){
//            JSONObject jsonObject1= jsonArray.getJSONObject(i);
//            System.out.println(String.format(fromateStr,jsonObject1.getString("ITEMNAME"),jsonObject1.getString("ITEM_CODE")));
//        }
    }


}