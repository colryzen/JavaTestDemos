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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class SqlBuildTest {

   public static  String json = "  {\n" +
           "            \"ENTERID\": \"85e16d45-3a65-41c2-8e71-3ca61980d9c8\",\n" +
           "            \"CODE_REGION\": \"350700000000\",\n" +
           "            \"STANDENTERID\": \"0b8e1568-b51b-44ae-af53-6d4207363573\",\n" +
           "            \"DATASOURCE\": \"国家排污许可证\",\n" +
           "            \"YEAR\": 2018,\n" +
           "            \"ENTERADDRESS\": \"南平市延平区太平镇南溪村\",\n" +
           "            \"ENTERNAME\": \"南平恒富纸业有限公司\",\n" +
           "            \"PKID\": \"2018GJPWXKZ_85e16d45-3a65-41c2-8e71-3ca61980d9c8\",\n" +
           "            \"LONGITUDE\": null,\n" +
           "            \"LATITUDE\": null,\n" +
           "            \"UPDATETIME\": \"2018-03-23 11:57:14\"\n" +
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

        readLineCreateTable();
       // readLine();
        int a = 1;

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

     //    System.out.println( stringBuffer.toString());

         String fromateStr="(E'8a1e8dbc5b66b092015bccf96ee75194',E'0107',E'LETTERCODE',E'Z_LetterComplaint',E'column',E'letterCode',E'table',E'信件编号'),";

         JSONArray jsonArray =JSONArray.parseArray(formJson);


//        for(int i=0;i<jsonArray.size();i++){
//            JSONObject jsonObject1= jsonArray.getJSONObject(i);
//            System.out.println(String.format(fromateStr,jsonObject1.getString("ITEMNAME"),jsonObject1.getString("ITEM_CODE")));
//        }



    }


     private static void readLine(){
         Path path= Paths.get("/Users/ruankerui/Developer/test/table","2_4_3.txt");
         try {
             ArrayList<String> lines= (ArrayList<String>) Files.readAllLines(path);
             StringBuffer stringBuffer = new StringBuffer();

             for(String key :lines){
                 // String jsonKey= StringKeyChangeTool.lineToHump(key);
                 String jsonKey= key.trim();
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