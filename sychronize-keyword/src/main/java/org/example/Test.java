package org.example;


class Display{ // resource

     void print(){
        Thread t = Thread.currentThread();
        synchronized (this){  // this keyword දානවා class එකට join කරන්න.
            for (int i=0; i<5; i++){
                try {
                    Thread.sleep(1000);
                    System.out.println(t.getName());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }


    }

    }
}

class T extends Thread{ // to make threads
    Display c;
    T(Display c){
        this.c = c;
    }

    public void run(){
        c.print();
    }
}

public class Test {

    public static void main(String[] args) {
        Display obj = new Display();

        T t1 = new T(obj);
        T t2 = new T(obj);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("bye");

    }


}
