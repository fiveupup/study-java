package com.metayoo.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4, () -> {
            System.out.println("所有线程都达到屏障点！");
        });

        for (int i = 0; i < 4; i++) {
            new Thread(new MyTask(barrier)).start();
        }
    }

    static class MyTask implements Runnable {

        private CyclicBarrier barrier = null;
        public MyTask(CyclicBarrier barrier) {
            this.barrier = barrier;
        }
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "正在执行任务1...");
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                barrier.await();
                System.out.println(Thread.currentThread().getName() + "执行下一个任务...");
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
