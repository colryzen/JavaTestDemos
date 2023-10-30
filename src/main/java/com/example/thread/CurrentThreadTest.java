package com.example.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.LongAdder;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;

public class CurrentThreadTest {

    private static AtomicInteger i = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {

        testAtomic();
        testAdder();

        testAtomicFieldUpdater();

        testCookingAndConsumer();


    }

    public  static void testAtomicFieldUpdater(){


        System.out.println("======= 更新原子属性 ========");
        Student student = new Student();


       AtomicIntegerFieldUpdater<Student> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Student.class, "age");
        System.out.println(fieldUpdater.incrementAndGet(student));

    }

    public static class Student{
        volatile int age;
    }



    public  static void testAtomic() throws InterruptedException {
        AtomicInteger integer = new AtomicInteger(10);
        System.out.println(integer.compareAndSet(30, 20));
        System.out.println(integer.compareAndSet(10, 20));
        System.out.println(integer);
        Runnable r = () -> {
            for (int j = 0; j < 100000; j++)
            {
                i.getAndIncrement();
            }
            System.out.println("自增完成！");
        };
        new Thread(r).start();
        new Thread(r).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(i.get());
    }




    public  static void testAdder() throws InterruptedException {

        System.out.println("======= LongAdder ========");
        LongAdder adder = new LongAdder();
        Runnable r = () -> {
            for (int i = 0; i < 10; i++)
            {
                adder.add(1);
            }
        };
        for (int i = 0; i < 100; i++){
            new Thread(r).start();   //100个线程
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println(adder.sum());   //最后求和即可

    }


    /**
     * 通过多线程编程，来模拟一个餐厅的2个厨师和3个顾客，
     * 假设厨师炒出一个菜的时间为3秒，顾客吃掉菜品的时间为4秒，窗口上只能放一个菜。
     * 我们来看看，使用阻塞队列如何实现，这里我们就使用ArrayBlockingQueue实现类
     */
    public static  void testCookingAndConsumer(){
        BlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
        Runnable supplier = () -> {
            while (true){
                try {
                    String name = Thread.currentThread().getName();
                    System.err.println(time()+"生产者 "+name+" 正在准备餐品...");
                    TimeUnit.SECONDS.sleep(3);
                    System.err.println(time()+"生产者 "+name+" 已出餐！");
                    queue.put(new Object());
                    System.out.println("queue ="+queue.remainingCapacity());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        };
        Runnable consumer = () -> {
            while (true){
                try {
                    String name = Thread.currentThread().getName();
                    System.out.println(time()+"消费者 "+name+" 正在等待出餐...");
                    queue.take();
                    System.out.println(time()+"消费者 "+name+" 取到了餐品。");
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println(time()+"消费者 "+name+" 已经将饭菜吃完了！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        };
        for (int i = 0; i < 1; i++) {
            new Thread(supplier, "Supplier-" + i).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(consumer, "Consumer-" + i).start();
        }
    }






}
