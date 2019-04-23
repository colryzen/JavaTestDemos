package com.example.base;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    int i;
     float sort;

    public static void main(String[] args) {

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY,48);
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(calendar.getTime()));
        String[] str = new String[] { "you", "wu" };
        List list = Arrays.asList(str);


       StringTest stringTest =new StringTest();
       stringTest.transformVersions();
        Map<String, String> map =new HashMap<String, String>();

         System.out.println(map.get("a"));

        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><root"
                + " sessid='"+"9A323F263911285752D5DC606A9614F5"
                + " start='"+0+"' count='"+20 +"'>";

        System.out.println("xml = [" + xml + "]");

         System.out.println(IsUrl("http://www.baidu.com"));
         System.out.println(IsUrl("http://www.baidu.com/me/"));
         System.out.println(IsUrl("http://www.baidu.com/me/id?=5&and=9"));
         System.out.println(IsUrl("http://www.baidu/me/"));
         System.out.println(IsUrl("http://192.110.11.1:9090/me/"));
         System.out.println(IsUrl("http://255.255.255.1/me/"));
         System.out.println(IsUrl("https://255.255.255.1:80/me/?path=&test="));
         System.out.println(IsUrl("https://255.255.255.1:80/me/dox.asp?path=&test="));
         System.out.println(IsUrl("https://255.255.255.1:80/me/index.html#?path=&test="));
         System.out.println(IsUrl("http://www.baidu/我们/"));


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
        System.out.println("args = [" + sort + "]");
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

    public static boolean IsUrl(String str) {
        return match(PatternTest.WEB_URL.pattern(), str);
    }
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
