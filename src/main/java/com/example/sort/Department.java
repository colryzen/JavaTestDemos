package com.example.sort;


import java.io.Serializable;

/**
 * Created by 朱兴龙 on 2018/2/9.
 */

public class Department implements Serializable{
    String objectId;
    String id;
    String parentId;
    String departmentPath;
    String departmentName;
    int personToal;
    int sort;
    String orgId;
    String appId;
    int ischeck;
    int level=-1;


    public Department(  String id, String departmentPath) {
        this.id = id;
        this.departmentPath = departmentPath;
         //获取层级深度
         level=departmentPath.split("-").length;

    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getPersonToal() {
        return personToal;
    }

    public void setPersonToal(int personToal) {
        this.personToal = personToal;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentPath() {
        return departmentPath;
    }

    public void setDepartmentPath(String departmentPath) {
        this.departmentPath = departmentPath;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


    @Override
    public String toString() {
        return departmentPath;
    }
}
