package com.example.sort;

import java.util.Comparator;

public class DepartmentCompartor implements Comparator<Department> {


    public int compare(Department before, Department after) {
        return before.level-after.level ;
    }

}
