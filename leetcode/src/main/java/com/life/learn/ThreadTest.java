package com.life.learn;

import lombok.val;

public class ThreadTest {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();

        threadDemo.start();
    }

    public void man() {

         ThreadDemo threadDemo = new ThreadDemo();

         threadDemo.start();
    }
}
