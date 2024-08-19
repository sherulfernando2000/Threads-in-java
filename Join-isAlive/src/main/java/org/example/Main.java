package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Runnable a = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        };

        Runnable b = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("B ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread threadA = new Thread(a);
        Thread threadB = new Thread(b);
        threadA.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        threadB.start();
        System.out.println(threadA.isAlive());
        //threadA.join(); // thread A එක join wenakan inna.. ita passe main thread eka ilaga line ekata yanna
        System.out.println(threadA.isAlive());
        //threadB.join(); // thread B join wenakan inna main thread ekata ita passe ilanga line ekata yanna

        System.out.println("Bye");
    }
}