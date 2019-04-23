package com.example.rxjava;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class TestRxjava2 {

    public static void main(String[] args) {
        System.out.println("args = ");
        Flowable.just("oK").doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("currtThread 1 ="+Thread.currentThread().getName() );
                s="Not OK";
            }
        }).subscribeOn(Schedulers.io()).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("currtThred 2 ="+Thread.currentThread().getName() );
            }
        }).observeOn(Schedulers.io()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("s=" + s + " , currtThred 3 =" + Thread.currentThread().getName());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.println("currtThred 4 =" + Thread.currentThread().getName());
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("Action !!" + Thread.currentThread().getName());
            }
        });



        Flowable.just("ERROR").flatMap(new Function<String, Publisher<String>>() {
            @Override
            public Publisher<String> apply(String s) throws Exception {
                Publisher<String> publisher =new Publisher<String>() {
                    @Override
                    public void subscribe(Subscriber<? super String> subscriber) {
                         subscriber.onNext(" I'm OK !!!");
                    }
                };

                return publisher;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("s = [" + s + "]");
            }
        });

    }

}
