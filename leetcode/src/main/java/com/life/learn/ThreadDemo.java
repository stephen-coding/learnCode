package com.life.learn;


import com.life.SomeParam;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {

   static int tickets = 15;

   class SellTickets implements Runnable {

      Lock lock = new ReentrantLock();

      @Override
      public void run() {

         while (tickets > 0) {
            try {

               lock.lock();
               if (tickets <= 0) {
                  return;
               }
               System.out.println(Thread.currentThread().getName() + "----售出第" + "ticket----");
               tickets--;
            } catch (Exception e) {

               e.printStackTrace();
            } finally {

               lock.unlock();
               try {
                  Thread.sleep(1);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }

         }


            System.out.println("售票结束");

      }
   }

   public static void main(String[] args) {

      SellTickets sellTickets = new ThreadDemo().new SellTickets();
      Thread thread1 = new Thread(sellTickets, "1号窗口");
      Thread thread2 = new Thread(sellTickets, "2号窗口");
      Thread thread3 = new Thread(sellTickets, "3号窗口");

      thread1.start();
      thread2.start();
      thread3.start();
   }

}
