package com.example.haixl.androidtestapplication.base;

import android.os.Handler;
import android.os.Looper;

public abstract class BaseViewModelManager extends BaseClassManager{

    private static Handler handler = new Handler(Looper.getMainLooper());

    protected static void runOnUITHread(Runnable runnable){
        handler.post(runnable);
    }

    protected void runOnUITHreadDelay(Runnable runnable,long delayMillis){
        handler.postDelayed(runnable,delayMillis);
    }

}
