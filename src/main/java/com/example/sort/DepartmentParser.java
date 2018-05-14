package com.example.sort;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class DepartmentParser {


    public static void main(String[] args) {
        String departAry="[{\n" +
                "\t\t\"id\": \"n1de8d3d-91a4-400e-9993-848c8d4fdfe2\",\n" +
                "\t\t\"departmentPath\": \"云服务事业部-云服务事业部-测试部门新增-阿锐组\",\n" +
                "\t\t\"duties\": \"码农代表\",\n" +
                "\t\t\"sort\": 1\n" +
                "\t},\n" +
                "\n" +
                "\t{\n" +
                "\t\t\"id\": \"df85ce7a-4c5a-4a85-bbfe-87b9cf589351\",\n" +
                "\t\t\"departmentPath\": \"云服务事业部-云服务事业部-平台组\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"d1de8d3d-91a4-400e-9993-848c8d4fdfe2\",\n" +
                "\t\t\"departmentPath\": \"云服务事业部-云服务事业部-测试部门新增\",\n" +
                "\t\t\"duties\": \"码农代表\",\n" +
                "\t\t\"sort\": 1\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"f96592dd-98bb-4b84-9214-943bc0f517dd\",\n" +
                "\t\t\"departmentPath\": \"云服务事业部-云服务事业部-测试部门新增2\",\n" +
                "\t\t\"duties\": \"码农代表\",\n" +
                "\t\t\"sort\": 1\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"kf85ce7a-4c5a-4a85-bbfe-87b9cf589351\",\n" +
                "\t\t\"departmentPath\": \"云服务事业部-云服务事业部-平台组-及时云小组\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"n1de8d3d-91a4-400e-9993-848c8d4fdfe2\",\n" +
                "\t\t\"departmentPath\": \"云服务事业部-质量委员会-测试部门新增-阿锐组\",\n" +
                "\t\t\"duties\": \"码农代表\",\n" +
                "\t\t\"sort\": 1\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"n1de8d3d-91a4-400e-9993-848c8d4fdfe2\",\n" +
                "\t\t\"departmentPath\": \"云服务事业部-效率委员会\",\n" +
                "\t\t\"duties\": \"码农代表\",\n" +
                "\t\t\"sort\": 1\n" +
                "\t}\n" +
                "]";

        try {
            JSONArray jsonArray =new JSONArray(departAry);
            System.out.println(jsonArray.toString());
            LinkedList<Department> arrayList= new LinkedList<Department>();
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.optJSONObject(i);
                Department department =new Department(jsonObject.optString("id"),jsonObject.optString("departmentPath"));
                arrayList.add(department);
            }
            System.out.println(arrayList.toString());
            DepartmentParser departmentParser =new DepartmentParser();
            LinkedList<Department> resultLsit=departmentParser.rootMerge(arrayList);
            System.out.println("合并后结果："+resultLsit.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /**
     *  合并部门路径，返回根节点部门
     * @param departmentsList 部门列表
     * @return
     */
    public   LinkedList<Department> rootMerge(LinkedList<Department>  departmentsList){
        //按层级排序
        Collections.sort(departmentsList,new DepartmentCompartor());
        System.out.println("排序后："+departmentsList.toString());
        LinkedList<Department> rootList= new LinkedList<Department>();
        while (!departmentsList.isEmpty()){
            //队列不为空,取出队列第一个，并移除
            Department root =departmentsList.poll();
            if(root!=null){
                rootList.add(root);
                //移除子节点
                removeSon(root,departmentsList);
            }
        }
        return rootList;
    }

    private  void removeSon(Department root,LinkedList<Department>  list){
        LinkedList<Department> removeList= new LinkedList<Department>();
        for(Department department :list){
            if(department.departmentPath.startsWith(root.departmentPath)&&department.level>root.level){
                //判断是否是子节点
                removeList.add(department);
            }
        }
        //移除子节点
        list.removeAll(removeList);
    }
}
