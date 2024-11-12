package com.metayoo.thread;

public class VolatileExample {
    private volatile boolean flag = false;
    public void someMethod() {
        if (flag) {
            // do something.
        }
    }
}
