package com.metayoo.thread;

import java.util.concurrent.TimeUnit;

public class Synchronize1Test {
    public static void main(String[] args) throws Exception {
        for (int j = 0; j < 100; j++) {
            Data data = new Data(1);
            for (int i = 0; i < 100; i++) {
                Thread thread = new Thread(new MyThread(data));
                thread.start();
                thread.join();
            }

            System.out.println(data.value);
        }
    }

    static class Data {
        int value;

        Data(int value) {
            this.value = value;
        }

        public synchronized void incr() {
            this.value = this.value + 1;
        }
    }

    static class MyThread implements Runnable {
        Data data;

        MyThread(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            this.data.incr();
        }
    }
}
