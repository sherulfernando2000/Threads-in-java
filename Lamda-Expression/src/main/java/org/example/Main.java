package org.example;

public class Main {
    public static void main(String[] args) {

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
       threadB.start();
    }
}