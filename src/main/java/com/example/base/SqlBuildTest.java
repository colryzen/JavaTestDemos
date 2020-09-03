package com.example.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.util.StringKeyChangeTool;
import com.sun.tools.javac.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class SqlBuildTest {

   public static  String json = "  {\n" +
           "            \"DQ_UCODE\": \"350700\",\n" +
           "            \"YEARMONTH\": \"2019-11-22\",\n" +
           "            \"STANDNAME\": \"2016年起地表水（GB3838-2002）（小流域）\",\n" +
           "            \"LONGITUDE\": 117.7786,\n" +
           "            \"CHECKCLASS\": \"省控\",\n" +
           "            \"BNAME\": \"闽江流域\",\n" +
           "            \"POINTTYPE\": \"考核\",\n" +
           "            \"ESTUARY\": \"非\",\n" +
           "            \"CHECKYEAR\": 2019,\n" +
           "            \"UCODE\": \"350700\",\n" +
           "            \"PNAME\": \"漫水桥\",\n" +
           "            \"REC_ID\": \"13832\",\n" +
           "            \"RECDATE\": \"2019-12-10\",\n" +
           "            \"FREQUENCY\": null,\n" +
           "            \"THETYPE\": 2,\n" +
           "            \"RCODE\": \"317\",\n" +
           "            \"ISADDCHECK\": \"非\",\n" +
           "            \"TOTALCLASS\": 3,\n" +
           "            \"REPRESENT\": \"是\",\n" +
           "            \"STREAM\": null,\n" +
           "            \"CBITEMS\": null,\n" +
           "            \"PLACE\": \"中中\",\n" +
           "            \"FEATURES\": null,\n" +
           "            \"CHECKMONTH\": 11,\n" +
           "            \"OUTFALL\": \"是\",\n" +
           "            \"UNAME\": \"南平市\",\n" +
           "            \"BORDER\": \"非交界\",\n" +
           "            \"DQ_UNAME\": \"南平市\",\n" +
           "            \"RNAME\": \"仁寿溪\",\n" +
           "            \"PCODE\": \"429\",\n" +
           "            \"POINT\": \"非\",\n" +
           "            \"LATITUDE\": 26.9289,\n" +
           "            \"CONTROL\": \"非\"\n" +
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





   String  columns="ID\n" +
           "OBJECT_NAME\n" +
           "BELONG_AREA_ID\n" +
           "BELONG_AREA_NAME\n" +
           "ADDRESS\n" +
           "POWER_AREA_ID\n" +
           "POWER_AREA_NAME\n" +
           "GIS_COORDINATE_X\n" +
           "GIS_COORDINATE_Y\n" +
           "LICENSE_NO\n" +
           "ORG_CODE\n" +
           "SOCIAL_CREDIT_CODE\n" +
           "INDUSTRY_TYPE_CODE\n" +
           "INDUSTRY_TYPE_NAME\n" +
           "LEVEL_NAME\n" +
           "LEGAL_PERSON\n" +
           "LEGAL_PHONE\n" +
           "CHARGE_PERSON\n" +
           "CHARGE_PERSON_PHONE\n" +
           "IS_KEY_SOURCE\n" +
           "IS_ONLINE_MONITOR\n" +
           "PRODUCT_STATE_NAME\n" +
           "IS_SOLIDWASTE_OPERUNIT\n" +
           "IS_SOLIDWASTE_CREATEUNIT\n" +
           "IS_RISK_SOURCE\n" +
           "IS_OUTFALL_STANDARD\n" +
           "PERSON_NATURE_NAME\n" +
           "BELONG_LEVEL_CODE\n" +
           "BELONG_LEVEL_NAME\n" +
           "IS_LISTED_COMPANY\n" +
           "STOCK_CODE\n" +
           "IS_GROUP_COMPANY\n" +
           "GROUP_COMPANY_NAME\n" +
           "GROUP_COMPANY_ORGCODE\n" +
           "GROUP_COMPANY_STOCKCODE\n" +
           "PERSONCARD_TYPE_NAME\n" +
           "CARD_NUMBER\n" +
           "CARD_TYPE_NAME\n" +
           "IS_SPECIAL_ORG\n" +
           "MANAGE_ORG_NAME\n" +
           "TYPE_NAME\n" +
           "SEX\n" +
           "DELMARK\n" +
           "PROTECTED_AREA_DESC\n" +
           "MAIN_PROTECT_OBJECT\n" +
           "OBJECT_DESC\n" +
           "UPDATETIME\n" +
           "CREATETIME\n" +
           "DANGER_COEFFICIENT\n" +
           "RANDOM_STATE\n" +
           "RANDOM_ATTR_NAME\n" +
           "LASTUPDATEMAN\n" +
           "LEGAL_MAN_ID_CARD\n" +
           "CHARGE_MAN_ID_CARD\n" +
           "STANDENTERID\n" +
           "WSCD\n" +
           "WSNM\n" +
           "POLLUTION_SOURCE_TYPE\n" +
           "POLLUTION_SOURCE_TYPE_NAME\n" +
           "XSLW\n" +
           "SFFSCSDW\n" +
           "SFFQCSDW\n" +
           "SFWFCSDW\n" +
           "SFWFJYDW\n" +
           "SYPWXKHYJSGF_CODE\n" +
           "SYPWXKHYJSGF_NAME\n" +
           "IS_CANCELLED\n" +
           "SUPERVISE_DATE\n" +
           "IS_SUPERVISE\n" +
           "GIS_COORDINATE_X84\n" +
           "GIS_COORDINATE_Y84\n";





    public static void main(String[] args) {

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


    }


     private static void readLine(){
         Path path= Paths.get("/Users/ruankerui/Developer/test/table","2.3.txt");
         try {
             ArrayList<String> lines= (ArrayList<String>) Files.readAllLines(path);
             StringBuffer stringBuffer = new StringBuffer();

             for(String key :lines){
                  String jsonKey= StringKeyChangeTool.lineToHump(key);
                // String jsonKey= key.trim();
                 stringBuffer.append(" \"").append(jsonKey).append("\" text ,");
             }
             System.out.println( stringBuffer.toString());

         } catch (IOException e) {
             e.printStackTrace();
         }

     }

     private static void readLineCreateTable(){
         Path path= Paths.get("/Users/ruankerui/Developer/test/table","2_9_0.txt");
         try {
             ArrayList<String> lines= (ArrayList<String>) Files.readAllLines(path);
             StringBuffer stringBuffer = new StringBuffer();

             for(String key :lines){
                 // String jsonKey= StringKeyChangeTool.lineToHump(key);
                 String jsonKey= key.trim();
                 stringBuffer.append(" \"").append(keyChange(jsonKey)).append("\" text ,");
             }
             System.out.println( stringBuffer.toString());


             String fromateStr="(E'8a1e8dbc5b66b092015bccf96ee75194',E'0107',E'%1$s',E'Z_LetterComplaint',E'column',E'%2$s',E'table'),";

             StringBuffer insertBuffer = new StringBuffer();

             for(String key :lines){
                 // String jsonKey= StringKeyChangeTool.lineToHump(key);
                 String jsonKey= key.trim();
                 insertBuffer.append(String.format(fromateStr,jsonKey.toUpperCase(),keyChange(jsonKey)));
             }
             System.out.println(insertBuffer.toString());

         } catch (IOException e) {
             e.printStackTrace();
         }
     }




     private static String keyChange(String key){
         HashMap map =new HashMap();
         map.put("LETTERCODE","complaintCode");
         // 案件来源
         map.put("RESOURCEL","complaintSource");
         // 污染源类型
         map.put("POLLUTIONTYPE","pollutionType");
         //举报人
         map.put("PETITIONER","complainantName");
         // 举报人联系方式
         map.put("PETITIONERTEL","complainantLinkMethod");
         // 举报人地址
         map.put("PETITIONERADDR","complainantAddr");
         // 举报内容
         map.put("PETICONTENT","complaintContent");
         // 被举报单位名称
         map.put("PENAME","enterpriseName");
         // 被举报单位地址
         map.put("PEADDR","address");
         // 被举报单位所在区县
         map.put("POLLUTIONCOUNTY","regionName");
         // 投诉时间(登记时间)
         map.put("INSERTTIME","complaintTime");
         // 回复时间（办理时间)
         map.put("PETITIONTIME","replyTime");
         // 是否受理 1受理 0未受理
         map.put("ISACCEPT","isAccept");
         // 转办状态(转办状态（0，转办；1，市级督办；2，省级督办）)
         map.put("HANLDTYPE","transferDealStatus");
         // 反馈状态(反馈状态)
         map.put("FEEDBACKSTATUS","feedbackStatus");

         if(map.containsKey(key.toUpperCase())){
             return  (String)map.get(key.toUpperCase());
         }else{
             return  key;
         }

     }


}