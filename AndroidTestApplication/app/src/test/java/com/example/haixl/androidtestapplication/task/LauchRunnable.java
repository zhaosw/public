package com.example.haixl.androidtestapplication.task;

public abstract class LauchRunnable implements Runnable {

    private LauchListener lauchListener = null;

    public void LauchRunnable(){

    }

    public void setLauchListener(LauchListener lauchListener){
        this.lauchListener = lauchListener;
    }

    @Override
    public void run() {
        go();
        if(null != lauchListener){
            lauchListener.onStop();
        }
    }

    protected abstract void go();

    public interface LauchListener{
        void onStop();
    }

}
