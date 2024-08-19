package org.example;


class Calculation {
    int num = 0;

     void increment(){
        num++;
    }


}

public class Main {


    public static void main(String[] args) throws InterruptedException {

      /*Calculation calculation = new Calculation();
      calculation.start();*/

        Calculation calculation = new Calculation();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                calculation.increment();
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                calculation.increment();
            }
        });

        t1.start();
        t2.start();

        //main thread eka 1s ekakata sleep karanawa sub process 2 t1, t2 iwara wenakan
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        System.out.println(calculation.num);

    }
}