package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread{
    Semaphore sm;
    CountDownLatch cdl;
    int id;

    public Downloaders(Semaphore sm,int id) {
        this.sm = sm;
        this.id = id;
    }

    @Override
    public void run() {

        try {
            sm.acquire();
        } catch (InterruptedException e) {

        }
        System.out.println("Пользователь " + id + " начал загрузку");
        try {
            sleep(1000);
        } catch (InterruptedException e) {

        }
        for (int i = 1; i <= 5 ; i++) {

            System.out.println("Пользователь " + id +  " загрузил " + 100 * i + "мб");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sm.release();
        super.run();
    }
}
