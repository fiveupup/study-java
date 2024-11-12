package com.metayoo.thread;

import java.util.concurrent.Executors;

public class ExecutorsTest {
    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(1);
    }
}
