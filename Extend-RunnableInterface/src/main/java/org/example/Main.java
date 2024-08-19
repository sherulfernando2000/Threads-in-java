package org.example;



    class A implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i <= 20; i++) {
                System.out.println("A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            }

        }
    }

    class B implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i <= 20; i++) {
                System.out.println("B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

public class Main {
    public static void main(String[] args) {
        A a = new A();
        Thread threadA = new Thread(a);
        threadA.start();

        B b = new B();
        Thread threadB = new Thread(b);
        threadB.start();
    }
}