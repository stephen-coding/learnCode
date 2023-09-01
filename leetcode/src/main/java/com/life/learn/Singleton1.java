package com.life.learn;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class Singleton1 {

    private Singleton1(){
    }

    private static final Singleton1 singleton1 = new Singleton1();
    public static Singleton1 getInstance() {
        return singleton1;
    }
    private static String createId() {

        ReentrantLock lock = new ReentrantLock();
        String id;
        try {
            lock.lock();
            LocalDateTime time = LocalDateTime.now();
            //本月几号
            int dayOfMonth = time.getDayOfMonth();
            //月份
            int monthValue = time.getMonthValue();
            //年份
            int year = time.getYear();
            int geiwei = year % 10;
            int shiwei = year % 100 / 10;
//            Integer todayCount = cfgBusinessTreeMapper.countTreeNodeToday(year + "-" + monthValue + "-" + dayOfMonth);
//            todayCount++;
            id = shiwei + geiwei + monthValue + dayOfMonth + "-" + 1000;
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder append = stringBuilder
                    .append(shiwei)
                    .append(geiwei)
                    .append(monthValue)
                    .append(dayOfMonth).append("-").append(1000);


            System.out.println(append);

        } finally {
            lock.unlock();
        }

        return id;
    }

    public static void main(String[] args) {
        createId();
    }
}
