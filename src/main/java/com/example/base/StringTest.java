package com.example.base;

public class StringTest {


    public static void main(String[] args) {
       StringTest stringTest =new StringTest();
       stringTest.transformVersions();

    }


    public String versionsnumber(int s)
    {
        String a1="";
        if (s<9)
        {
            a1="0"+s;
        }else {
            a1=String.valueOf(s);
        }
        return  a1;
    }

    public int transformVersions() {
        String versions = "1.12.2.1";
        String v[] = versions.split("\\.");
        int a = Integer.parseInt(v[0]);
        int b = Integer.parseInt(v[1]);
        int c = Integer.parseInt(v[2]);
        String a1 = versionsnumber(a);
        String b1 = versionsnumber(b);
        String c1 = versionsnumber(c);
        int version = Integer.parseInt(a1 + b1 + c1);
        System.out.println( "version="+version + "");
        return version;
    }
}
