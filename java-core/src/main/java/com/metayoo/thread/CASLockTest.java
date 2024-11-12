package com.metayoo.thread;

import java.util.concurrent.atomic.AtomicBoolean;

public class CASLockTest {

    private final AtomicBoolean lock = new AtomicBoolean(false);

    public void lock() {
        while (!lock.compareAndSet(false, true)) {
            // 自旋等待，等待释放锁
        }
    }

    public void unlock() {
        lock.set(false);
    }
}
