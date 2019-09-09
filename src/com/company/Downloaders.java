package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread {
    Semaphore sm;
    CountDownLatch cdl2;
    int id;

    public Downloaders(Semaphore sm, CountDownLatch cdl2, int id) {
        this.sm = sm;
        this.id = id;
        this.cdl2 = cdl2;
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
        for (int i = 1; i <= 5; i++) {

            System.out.println("Пользователь " + id + " загрузил " + 100 * i + "мб");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sm.release();
        cdl2.countDown();
        super.run();
    }
}
