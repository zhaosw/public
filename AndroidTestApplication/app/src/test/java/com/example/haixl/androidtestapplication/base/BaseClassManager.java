package com.example.haixl.androidtestapplication.base;

import com.example.haixl.androidtestapplication.task.LauchRunnable;
import com.example.haixl.androidtestapplication.util.ThreadPoolManager;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class BaseClassManager {

    private CountDownLatch countDownLatch = null;

    private int countDownCount = 0;

    protected void init(){
        countDownLatch = new CountDownLatch(countDownCount);
    }

    protected void await(){
        if(null != countDownLatch){
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void awaitTime(long time){
        if(null != countDownLatch){
            try {
                countDownLatch.await(time,TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void countDown(){
        countDownLatch.countDown();
    }

    protected void runOnThread(Runnable runnable){
        ThreadPoolManager.getInstance().addThreadTask(runnable);
    }

    protected void runOnThreadDelay(Runnable runnable,long delayMillis){
        ThreadPoolManager.getInstance().addDelayTask(runnable,delayMillis, TimeUnit.MILLISECONDS);
    }

    protected void runOnThreadSync(LauchRunnable runnable){
        runnable.setLauchListener(new LauchRunnable.LauchListener() {
            @Override
            public void onStop() {
                countDown();
            }
        });
        ThreadPoolManager.getInstance().addThreadTask(runnable);
        await();
    }

    protected void runOnThreadSyncTime(LauchRunnable runnable,long timeMillis){
        awaitTime(timeMillis);
        runnable.setLauchListener(new LauchRunnable.LauchListener() {
            @Override
            public void onStop() {
                countDown();
            }
        });
        ThreadPoolManager.getInstance().addThreadTask(runnable);
        await();
    }

    protected void runOnThreadSyncDelay(LauchRunnable runnable,long delayMillis){
        runnable.setLauchListener(new LauchRunnable.LauchListener() {
            @Override
            public void onStop() {
                countDown();
            }
        });
        ThreadPoolManager.getInstance().addDelayTask(runnable,delayMillis, TimeUnit.MILLISECONDS);
        await();
    }

}
