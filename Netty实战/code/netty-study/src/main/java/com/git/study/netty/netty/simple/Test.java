package com.git.study.netty.netty.simple;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTaskRunnable runnable = new FutureTaskRunnable();
        FutureTask<String> futureTask = new FutureTask<>(runnable, "success");
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
        System.out.println("程序结束");
    }

    static class FutureTaskRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("程序正在运行");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
