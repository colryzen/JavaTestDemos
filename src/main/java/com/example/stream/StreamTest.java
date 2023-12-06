package com.example.stream;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *  演示Java 8 Stream的使用
 */
@Slf4j
public class StreamTest {
    //////////
    //知识点参考文章
    //1.  https://blog.csdn.net/MinggeQingchun/article/details/123184273
    //2.  https://blog.csdn.net/qq_45443475/article/details/131437679

    public static void main(String[] args) {
        log.info("==> StreamTest={}","we are OK!");
        createStream();

        List<User> userList=getUserList();
        List<String> mapUserList = userList.stream().map(user -> user.getName() + "用户").collect(Collectors.toList());
        mapUserList.forEach(System.out::println);

        userList.stream().flatMap(user -> Arrays.stream(user.getCity().split(","))).forEach(System.out::println);
        streamOp();

        //
        testReduce();

    }


    private static void createStream(){
        System.out.println("-------- =====createStream()===== -------------");
        //1、Stream创建
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
        //2.Collection集合创建（应用中最常用的一种）
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        Stream<Integer> listStream = integerList.stream();
        //3.Array数组创建
        int[] intArr = {1, 2, 3, 4, 5};
        IntStream arrayStream = Arrays.stream(intArr);
        //4、文件创建
        try {
            Stream<String> fileStream = Files.lines(Paths.get("data.txt"), Charset.defaultCharset());
            System.out.println("==========fileStream======");
            streamPrint(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //5. 函数创建
        Stream<Integer> iterateStream = Stream.iterate(0, n -> n + 2).limit(5);
        Stream<Double> generateStream = Stream.generate(Math::random).limit(5);

        System.out.println("==========");
        streamPrint(iterateStream);
        System.out.println("==========");
        streamPrint(generateStream);

        //6. 范围创建
        System.out.println("=====Range Create=====");
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }


    private static void streamOp(){
        System.out.println("-------- =====streamOp()===== -------------");
        List<User> userList=getUserList();
        //1、filter：输出ID大于6的user对象
        List<User> filetrUserList = userList.stream().filter(user -> user.getId() > 6).collect(Collectors.toList());
        System.out.println("=============filter===============");
        filetrUserList.forEach(System.out::println);
        //2、map
        List<String> mapUserList = userList.stream().map(user -> user.getName() + "用户").collect(Collectors.toList());
        System.out.println("=============map===============");
        mapUserList.forEach(System.out::println);
        //3、distinct：去重
        List<String> distinctUsers =  userList.stream().map(User::getCity).distinct().collect(Collectors.toList());
        System.out.println("=============distinct===============");
        distinctUsers.forEach(System.out::println);
        //4、sorted：排序，根据名字倒序
        System.out.println("=============sorted===============");
        userList.stream().sorted(Comparator.comparing(User::getName).reversed()).collect(Collectors.toList()).forEach(System.out::println);
        //5、limit：取前5条数据
        System.out.println("=============limit===============");
        userList.stream().limit(5).collect(Collectors.toList()).forEach(System.out::println);
        //6、skip：跳过第几条取后几条
        System.out.println("=============skip===============");
        userList.stream().skip(7).collect(Collectors.toList()).forEach(System.out::println);
        //7、flatMap：数据拆分一对多映射
        System.out.println("=============flatMap===============");
        userList.stream().flatMap(user -> Arrays.stream(user.getCity().split(","))).forEach(System.out::println);
        //8、peek：对元素进行遍历处理，每个用户ID加1输出
        System.out.println("=============peek===============");
        userList.stream().peek(user -> user.setId(user.getId()+1)).forEach(System.out::println);

    }


    private static List<User> getUserList() {
        List<User> userList = new ArrayList<>();

        userList.add(new User(1,"张三",18,"上海,福州"));
        userList.add(new User(2,"王五",16,"上海,广州,安徽"));
        userList.add(new User(3,"李四",20,"上海"));
        userList.add(new User(4,"张雷",22,"北京"));
        userList.add(new User(5,"张超",15,"深圳"));
        userList.add(new User(6,"李雷",24,"北京"));
        userList.add(new User(7,"王爷",21,"上海"));
        userList.add(new User(8,"张三丰",18,"广州"));
        userList.add(new User(9,"赵六",16,"广州"));
        userList.add(new User(10,"赵无极",26,"深圳"));

        return userList;
    }



    private static void testReduce() {
        System.out.println("-------- =====testReduce()===== -------------");
        //求和 sum
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        // 没有起始值时返回为Optional类型
        Optional<Integer> sumOptional = integers.stream().reduce(Integer::sum);
        System.out.println(sumOptional.get()); //15

        // 可以给一个起始种子值
        Integer sumReduce = integers.stream().reduce(10, Integer::sum);
        System.out.println(sumReduce); //15

        //直接用sum方法
        Integer sum = integers.stream().mapToInt(i -> i).sum();
        System.out.println(sum); //15

        Integer reduce = Stream.of(1, 2, 3).parallel().reduce(
                4,
                (integer, integer2) -> integer + integer2,
                (integer, integer2) -> integer + integer2);
        System.out.println(reduce); //18

        System.out.println("=============rangeClosed===============");
        Integer sumI= IntStream.rangeClosed(1, 10)
                .peek(System.out::println)
                .reduce(0, Integer::sum);
        System.out.println(sumI);
    }



    private static void streamPrint(Stream stream){
        stream.forEach(System.out::println);
    }


}
