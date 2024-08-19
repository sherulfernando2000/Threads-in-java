package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRunnable implements Runnable {
String name;

public MyRunnable(String name){
    this.name = name;

}
    @Override
    public void run() {
        System.out.println("Thread started: "+ name);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread Ended:"+ name);
    }


}
