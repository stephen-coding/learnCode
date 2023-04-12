package com.life.learn;

import lombok.val;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ThreadTest {

    public static AtomicInteger num = new AtomicInteger(1);
    public static Thread thread1 = null, thread2 = null;

    public static class PrintNumOdd implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (num.get() % 2 != 0 && num.get() <= 100) {

                    System.out.println(Thread.currentThread().getName() + " " + num);
                    num.incrementAndGet();
                    LockSupport.park();
                } else {
                    LockSupport.unpark(thread2);
                }
            }

        }
    }

    public static class PrintNumEven implements Runnable {

        @Override
        public void run() {

            while (true) {
                if (num.get() % 2 == 0 && num.get() <= 100) {

                    System.out.println(Thread.currentThread().getName() + " " + num);
                    num.incrementAndGet();
                    LockSupport.park();
                } else {
                    LockSupport.unpark(thread1);

                }
            }
        }
    }

    public static void main(String[] args) {
        final PrintNumOdd printNumOdd = new PrintNumOdd();
        final PrintNumEven printNumEven = new PrintNumEven();
        thread1 = new Thread(printNumOdd);
        thread2 = new Thread(printNumEven);
        thread1.setName("奇数");
        thread2.setName("偶数");
        thread1.start();
        thread2.start();
    }


}
