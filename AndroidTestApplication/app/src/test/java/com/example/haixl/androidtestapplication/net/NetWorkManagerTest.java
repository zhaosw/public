package com.example.haixl.androidtestapplication.net;

import android.app.Instrumentation;
import android.content.Context;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * @author zhaosw.
 * @date 2019/2/22.
 */
public class NetWorkManagerTest {

    @Test
    public void getUrl() {
    }

    @Test
    public void getBaidu() {
    }

    @Test
    public void testGetUserBeheaviorAsync() {
        NetWorkManager netWorkManager = new NetWorkManager();
        final CountDownLatch latch = new CountDownLatch(1);
        netWorkManager.getUserBeheaviorAsync(new NetWorkListener() {
            @Override
            public void onResponse(String response) {
                assertNotNull(response);
                assertEquals("reeponse faild!","success",response);
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAppName() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list.addAll(0,list1);
        assertEquals(list.size(),2);
    }
}