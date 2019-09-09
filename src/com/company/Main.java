package com.company;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(25);
        Semaphore sem = new Semaphore(3);
        Uploader uploader = new Uploader(cdl);
        uploader.start();
        try {
            cdl.await();
            for (int i = 1; i <= 10; i++) {
                Downloaders downloaders = new Downloaders(sem, i);
                downloaders.start();
            }

        } catch (InterruptedException e) {

        }
    }

}

