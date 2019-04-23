package com.example.sort;

import java.util.Comparator;

public class DepartmentCompartor implements Comparator<Department> {


    public int compare(Department before, Department after) {
        if(before.level>after.level){
            return  1;
        }

        if(before.level<after.level){
            return  -1;
        }

        return 0 ;
    }

}
