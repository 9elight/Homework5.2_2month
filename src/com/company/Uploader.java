package com.company;

import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread {
    CountDownLatch cdl;

    public Uploader(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        System.out.println("Загрузка файла на сервер");
        for (int i = 1; i <= 25; i++) {
            System.out.println("Загруженно " + 20 * i + " мб");
            try {
                sleep(1000);
                cdl.countDown();
            } catch (InterruptedException e) {

            }

        }
        System.out.println("Загрузка завершенна");
        super.run();

    }
}