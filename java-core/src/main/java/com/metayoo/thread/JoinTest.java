package com.metayoo.thread;

import java.util.concurrent.TimeUnit;

public class JoinTest {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("子线程执行完毕");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        thread.setDaemon(true);

        thread.start();

        System.out.println("主线程执行完毕");
    }
}
