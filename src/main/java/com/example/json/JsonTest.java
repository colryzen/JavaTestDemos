package com.example.json;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTest {

    public static void main(String[] args) {




        String  jsonStr="{\n" +
                "    \"departmentId\": [\n" +
                "        \"52a7f4c5-cf7e-4576-bd60-062b5ac93fdc\"\n" +
                "    ]\n" +
                "}";

        try {
            JSONObject jsonObject=new JSONObject(jsonStr);
            JSONArray jsonArray=jsonObject.optJSONArray("departmentId");
            for(int i=0;i<jsonArray.length();i++){
                System.out.println(jsonArray.optString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String json2="{\n" +
                "\t\"permissionId\": \"5aea82e62f301e003d040085\",\n" +
                "\t\"createdAt\": \"2018-05-14T02:54:18.348Z\",\n" +
                "\t\"role\": {\n" +
                "\t\t\"createdAt\": null,\n" +
                "\t\t\"className\": \"_Role\",\n" +
                "\t\t\"objectId\": \"5aeab46ed50eee00420d4f9d\",\n" +
                "\t\t\"updatedAt\": null\n" +
                "\t},\n" +
                "\t\"roleId\": \"5aeab46ed50eee00420d4f9d\",\n" +
                "\t\"appId\": \"cp2017004\",\n" +
                "\t\"permission\": {\n" +
                "\t\t\"createdAt\": \"2018-05-03T03:32:54.419Z\",\n" +
                "\t\t\"appId\": \"cp2017004\",\n" +
                "\t\t\"moduleName\": \"通讯录查询范围\",\n" +
                "\t\t\"className\": \"Permissions\",\n" +
                "\t\t\"power\": \"specificDepartment\",\n" +
                "\t\t\"moduleId\": \"contactsQueryRange\",\n" +
                "\t\t\"powerName\": \"特定部门\",\n" +
                "\t\t\"objectId\": \"5aea82e62f301e003d040085\",\n" +
                "\t\t\"updatedAt\": \"2018-05-03T06:44:25.861Z\"\n" +
                "\t},\n" +
                "\t\"className\": \"RolePermissions\",\n" +
                "\t\"orgId\": \"jg2017003\",\n" +
                "\t\"objectId\": \"5af8fa5a7f6fd3188a3108d0\",\n" +
                "\t\"extraInfo\": {\n" +
                "\t\t\"departmentId\": [\"52a7f4c5-cf7e-4576-bd60-062b5ac93fdc\"]\n" +
                "\t},\n" +
                "\t\"updatedAt\": \"2018-05-14T03:01:08.940Z\"\n" +
                "}";
        try {
            JSONObject jsonObject2=new JSONObject(json2);
           System.out.println(jsonObject2.optString("extraInfo"));
            System.out.println(jsonObject2.optJSONObject("extraInfo").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }



        String test="A-B-C";
        System.out.println(test.split("-").length);

        String[] pathAry=test.split("-");
        String regex="";
        for(int i=0;i<pathAry.length;i++){
            System.out.println("pathAry["+i+"]="+pathAry[i]);
            if(regex.length()==0){
                regex=String.format("^%s$|^%s-",pathAry[i],pathAry[i]);
            }else{
                regex=String.format("%s|^%s$|^%s-",regex,pathAry[i],pathAry[i]);
            }
        }
        System.out.println("regex:"+regex);
    }
}
