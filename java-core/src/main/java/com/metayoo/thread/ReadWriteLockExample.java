package com.metayoo.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void readMethod() {
        readWriteLock.readLock().lock();
        try {
            // do something
        } finally {
          readWriteLock.readLock().unlock();
        }
    }

    public void writeMethod() {
        readWriteLock.writeLock().lock();
        try {
            // do something
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
