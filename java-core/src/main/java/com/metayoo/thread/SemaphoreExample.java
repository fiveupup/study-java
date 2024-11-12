package com.metayoo.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            new Thread(new CarParking(semaphore, "Car" + i)).start();
        }
    }


    static class CarParking implements Runnable {

        private Semaphore semaphore;
        private String carName;
        public CarParking(Semaphore semaphore, String carName) {
           this.semaphore = semaphore;
           this.carName = carName;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.carName + "正试图进入停车场....");
                semaphore.acquire();
                System.out.println(this.carName + "成功进入停车场...");
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                System.out.println(this.carName + "释放了停车位，离开停车场...");
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
