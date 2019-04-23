package com.example.rxjava;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class TestRxjava {
    public static void main(String[] args) {


//        testCreate();
        testOperate();
  //      testScheduler();
        testScheduler2();

    }


    private static void testCreate(){
        System.out.println("testCreate()");

        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                observableEmitter.onNext(1);
                observableEmitter.onNext(2);
                //   observableEmitter.onError(null);
                //   observableEmitter.onComplete();
                observableEmitter.onNext(3);
            }
        });

        Observer<Integer> observer=new  Observer<Integer>() {

            Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe");
                mDisposable=disposable;
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext " +integer);
                if(integer==2){
                    mDisposable.dispose();

                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError"+ throwable.getMessage()  );
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        observable.subscribe(observer);


        // 2、Jsut 方式
        Observable.just(1).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

            }
        });

        //
        List<String> list = new ArrayList<String>();
        for(int i =0;i<10;i++){
            list.add("Hello"+i);
        }

        //fromIterable

        Observable.fromIterable((Iterable<String>) list).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("s = [" + s + "]");
            }
        });

        //defer()方式
        //当观察者订阅时，才创建Observable，并且针对每个观察者创建都是一个新的Observable。
        // 以何种方式创建这个Observable对象，当满足回调条件后，就会进行相应的回调。

        Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                return Observable.just("hello");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("s = [" + s + "]");
            }
        });


        //ranger
        System.out.println("ranger ");
        Observable.range(1,3).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("integer = [" + integer + "]");
            }
        });


        Flowable.range(1,2)
                .map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) throws Exception {
                return integer*integer;
            }
        }).doOnNext(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("切换前 Consumer 所在的线程："+Thread.currentThread().getName());
            }
        }).observeOn(Schedulers.computation()).doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("切换后 Consumer 所在的线程："+Thread.currentThread().getName());
                    }
                })
                .blockingSubscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("integer = [" + integer + "]");
                System.out.println("Consumer 所在的线程："+Thread.currentThread().getName());
            }
        });

         Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> flowableEmitter) throws Exception {
                flowableEmitter.onNext("test flowable");
            }
        },BackpressureStrategy.ERROR).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("s = [" + s + "]");
                System.out.println("Consumer 所在的线程："+Thread.currentThread().getName());
            }
        });

    }


     private static void testOperate(){


         System.out.println("======testOperate========");

         Observable observable1=   Observable.create(new ObservableOnSubscribe<String>() {
             @Override
             public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                 observableEmitter.onNext("we");
                 observableEmitter.onNext("test");
             }
         });

         observable1.flatMap(new Function<String, ObservableSource<?>>() {
             ObservableEmitter<Integer> mObservableEmitter;
             @Override
             public ObservableSource<?> apply(final String s) throws Exception {
                 Observable observable1=   Observable.create(new ObservableOnSubscribe<Integer>() {
                     @Override
                     public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                        mObservableEmitter=observableEmitter;
                         mObservableEmitter.onNext(18);
                         observableEmitter.onNext(15);
                     }
                 });

//                 if(s.equals("we")){
//                     mObservableEmitter.onNext(50);
//                     mObservableEmitter.onNext(55);
//                 }else{
//                     mObservableEmitter.tryOnError(new Throwable("dfa"));
//                 }
                 return observable1 ;
             }
         }).subscribe(new Consumer<Object>() {
             @Override
             public void accept(Object s) throws Exception {
                 System.out.println("rsult=  s = [" + s + "]" + "s  is  Integer= " + (s instanceof Integer));
             }
         }, new Consumer<Throwable>() {
             @Override
             public void accept(Throwable throwable) throws Exception {
                 System.out.println("throwable = [" + throwable + "]");
             }
         });



           /////////////////////////
         //map()操作符

         //map()操作符，就是把原来的Observable对象转换成另一个Observable对象，
         // 同时将传输的数据进行一些灵活的操作，方便Observer获得想要的数据形式。

         Observable<Integer> observable = Observable.just("hello").map(new Function<String, Integer>() {
                     @Override
                     public Integer apply(String s) throws Exception {
                         return s.length();
                     }
                 });

         observable.subscribe(new Consumer<Integer>() {
             @Override
             public void accept(Integer integer) throws Exception {
                 System.out.println("integer = [" + integer + "]");
             }
         });






         //////////
         // flatMap

         // flatMap()对于数据的转换比map()更加彻底，如果发送的数据是集合，
         // flatmap()重新生成一个Observable对象，并把数据转换成Observer想要的数据形式。
         // 它可以返回任何它想返回的Observable对象。


         ArrayList<String> list= new  ArrayList<String>(){};

         list.add("we");
         list.add("are");
         list.add("chinese");

         Observable<Object> observable2 = Observable.just(list).flatMap(new Function<List<String>, ObservableSource<?>>() {
             @Override
             public ObservableSource<?> apply(List<String> strings) throws Exception {
                 return Observable.fromIterable(strings);
             }
         });


         observable2.subscribe(new Consumer<Object>() {
             @Override
             public void accept(Object s) throws Exception {
                 System.out.println("s = [" + s + "]" + "s  is  LIST= "+ (s instanceof List) );
             }
         });

         //////////////////////////////////////////
         //filter()操作符根据test()方法中，
         // 根据自己想过滤的数据加入相应的逻辑判断，返回true则表示数据满足条件，
         // 返回false则表示数据需要被过滤。最后过滤出的数据将加入到新的Observable对象中，
         // 方便传递给Observer想要的数据形式。

         System.out.println("filter()操作符：过滤结果");

         Observable.just(list).flatMap(new Function<List<String>, ObservableSource<?>>() {
             @Override
             public ObservableSource<?> apply(List<String> strings) throws Exception {
                 return Observable.fromIterable(strings);
             }
         }).filter(new Predicate<Object>() {
             @Override
             public boolean test(Object s) throws Exception {
                 String newStr = (String) s;
                 if (newStr.startsWith("we")) {
                     return true;
                 }
                 return false;
             }
         }).subscribe(new Consumer<Object>() {
             @Override
             public void accept(Object o) throws Exception {
                 System.out.println((String)o);
             }
         });



         //take()操作符：输出最多指定数量的结果。
         System.out.println("take()操作符：输出最多指定数量的结果。");
         Observable.just(list).flatMap(new Function<List<String>, ObservableSource<?>>() {
             @Override
             public ObservableSource<?> apply(List<String> strings) throws Exception {
                 return Observable.fromIterable(strings);
             }
         }).take(2).subscribe(new Consumer<Object>() {
             @Override
             public void accept(Object s) throws Exception {
                 System.out.println((String)s);
             }
         });


        //doOnNext()允许我们在每次输出一个元素之前做一些额外的事情。
         System.out.println("doOnNext()允许我们在每次输出一个元素之前做一些额外的事情");

         Observable.just(list).flatMap(new Function<List<String>, ObservableSource<?>>() {
             @Override
             public ObservableSource<?> apply(List<String> strings) throws Exception {
                 return Observable.fromIterable(strings);
             }
         }).take(5).doOnNext(new Consumer<Object>() {
             @Override
             public void accept(Object o) throws Exception {
                 System.out.println("准备工作");
             }
         }).subscribe(new Consumer<Object>() {
             @Override
             public void accept(Object s) throws Exception {
                 System.out.println((String)s);
             }
         });


         //zip
         System.out.println("zip");
         Observable<Integer> observable_1 = Observable.create(new ObservableOnSubscribe<Integer>() {
             @Override
             public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                 System.out.println( "emit 1");
                 emitter.onNext(1);
                 System.out.println( "emit 2");
                 emitter.onNext(2);
                 System.out.println( "emit 3");
                 emitter.onNext(3);
                 System.out.println( "emit 4");
                 emitter.onNext(4);
                 System.out.println( "emit complete1");
                 emitter.onComplete();
             }
         });

         Observable<String> observable_2 = Observable.create(new ObservableOnSubscribe<String>() {
             @Override
             public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                 System.out.println( "emit A");
                 emitter.onNext("A");
                 System.out.println( "emit B");
                 emitter.onNext("B");
                 System.out.println( "emit C");
                 emitter.onNext("C");
                 System.out.println( "emit complete2");
                 emitter.onComplete();
             }
         });

         Observable.zip(observable_1, observable_2, new BiFunction<Integer, String, String>() {
             @Override
             public String apply(Integer integer, String s) throws Exception {
                 return integer + s;
             }
         }).subscribe(new Observer<String>() {
             @Override
             public void onSubscribe(Disposable d) {
                 System.out.println( "onSubscribe");
             }

             @Override
             public void onNext(String value) {
                 System.out.println( "onNext: " + value);
             }

             @Override
             public void onError(Throwable e) {
                 System.out.println( "onError");
             }

             @Override
             public void onComplete() {
             }
         });




     }


     private  static void testScheduler(){

         System.out.println("======Scheduler========");


         Observable.create(new ObservableOnSubscribe<Integer>() {
             @Override
             public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                 System.out.println("subscribe 所在的线程："+Thread.currentThread().getName());
                 e.onNext(1);
             }
         }).subscribeOn(Schedulers.io())
                 .observeOn(Schedulers.newThread())
            //     .observeOn(Schedulers.single())
                .subscribe(new Consumer<Integer>() {
             @Override
             public void accept(Integer integer) throws Exception {
                 System.out.println("Consumer 所在的线程："+Thread.currentThread().getName());
                 System.out.println("接收到的数据：integer="+integer);

             }
         });



     }


    private  static void testScheduler2(){

        System.out.println("======Scheduler2========");


        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                System.out.println("subscribe2 所在的线程："+Thread.currentThread().getName());
                e.onNext(1);
            }
        }) .subscribeOn(Schedulers.io())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        System.out.println("map1 所在的线程："+Thread.currentThread().getName());
                        return integer+10;
                    }
                })
                .observeOn(Schedulers.computation())
//                //     .observeOn(Schedulers.single())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        System.out.println("map2 所在的线程："+Thread.currentThread().getName());
                        return integer+10;
                    }
                })
//                .observeOn(Schedulers.newThread())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        System.out.println("map3 所在的线程："+Thread.currentThread().getName());
                        return integer+10;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("Consumer 所在的线程："+Thread.currentThread().getName());
                        System.out.println("接收到的数据：integer="+integer);

                    }
                });

    }

}
