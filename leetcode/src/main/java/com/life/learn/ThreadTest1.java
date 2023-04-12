package com.life.learn;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ThreadTest1 {


    static Thread thread1 = null;
    static Thread thread2 = null;
    static Thread thread3 = null;
    static int i = 0;

    public static void main(String[] args) {

        final char[] code = {'A'};
        int num = 26;

        while (i < 26) {
            thread1 = new Thread(() -> {
                i++;
                System.out.println(code[0]);
                code[0] = (char) (code[0] + 1);
                LockSupport.unpark(thread2);
                LockSupport.park();

            });
            thread2 = new Thread(() -> {

                i++;
                LockSupport.park();
                System.out.println(code[0]);
                code[0] = (char) (code[0] + 1);
                LockSupport.unpark(thread3);


            });

            thread3 = new Thread(() -> {

                i++;
                LockSupport.park();
                System.out.println(code[0]);
                code[0] = (char) (code[0] + 1);
                LockSupport.unpark(thread1);


            });
        }




        thread1.start();
        thread2.start();
        thread3.start();




    }






}
