package com.example.thread;

import java.util.concurrent.*;

/**
 * 异步线程测试
 */
public class CompeletableFutureTest {


    ///////////
    //
    //参考文章地址： https://mp.weixin.qq.com/s/t9-PgUtYBVdaE_3w_LbKJw
    //
    //////////

    // thenApply 有入参数，有返回值
    // thenAccept 有入参数，无返回值
    // thenRun 无入参数无返回值


    public static void main(String[] args) throws ExecutionException, InterruptedException {
      // https://www.cnblogs.com/ludongguoa/p/15316488.html
        CompeletableFutureTest cft = new CompeletableFutureTest();
        cft.testSuppleAsync();

        cft.testRunAsync();


        cft.testThenApply();
        cft.testThenApplyAsync();

        cft.testWhenComplete();

        cft.testThenCombine();


    }

    //supplyAsync是创建带有返回值的异步任务
    public  void  testSuppleAsync() throws ExecutionException, InterruptedException {
        System.out.println("==========testSuppleAsync()=============");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("do something.... T:"+ Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result";
        }, executorService);

        //等待子任务执行完成
        System.out.println("结果->" + cf.get());

    }


    public void  testRunAsync() throws ExecutionException, InterruptedException {

        System.out.println("==========testRunAsync()=============");

        // 自定义线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println("do something....");
        }, executorService);

        //等待任务执行完成
        System.out.println("testRunAsync 结果->" + cf.get());

    }

    //thenApply 表示某个任务执行完成后执行的动作，即回调方法，会将该任务的执行结果即方法返回值作为入参传递到回调方法中，带有返回值
    public  void  testThenApply() throws ExecutionException, InterruptedException {

        System.out.println("==========testThenApply()=============");

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.thenApplyAsync((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            result += 2;
            return result;
        });
        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());

    }

    //发现thenApply和thenApplyAsync区别在于，使用thenApply方法时子任务与父任务使用的是同一个线程，而thenApplyAsync在子任务中是另起一个线程执行任务
    public  void testThenApplyAsync() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.thenApply((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            result += 2;
            return result;
        });
        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());

    }

    public  void testWhenComplete() throws ExecutionException, InterruptedException {

        System.out.println("==========testWhenComplete()=============");

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
           // int a = 1/0;
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.whenComplete((result, e) -> {
            System.out.println("上个任务结果：" + result);
            System.out.println("上个任务抛出异常：" + e);
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });

//        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
//        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());




    }


    public  void testThenCombine() throws ExecutionException, InterruptedException {

        System.out.println("==========testThenCombine()=============");

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            return 2;
        });

        CompletableFuture<Integer> cf3 = cf1.thenCombine(cf2, (a, b) -> {
            System.out.println(Thread.currentThread() + " cf3 do something....");
            return a + b;
        });

        System.out.println("cf3结果->" + cf3.get());


    }









}
