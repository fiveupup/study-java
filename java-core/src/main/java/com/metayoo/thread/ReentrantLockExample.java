package com.metayoo.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private ReentrantLock lock = new ReentrantLock();
    public void someMethod() {
        lock.lock();
        try {
            // do something
        } finally {
            lock.unlock();
        }
    }
}
