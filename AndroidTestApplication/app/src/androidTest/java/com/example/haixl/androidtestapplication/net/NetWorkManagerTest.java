package com.example.haixl.androidtestapplication.net;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.AndroidJUnitRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * @author zhaosw.
 * @date 2019/2/26.
 */
@RunWith(AndroidJUnit4.class)
public class NetWorkManagerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getUrl() {
    }

    @Test
    public void testGetBaidu() throws InterruptedException {
        NetWorkManager netWorkManager = new NetWorkManager();
        final CountDownLatch latch = new CountDownLatch(1);
        netWorkManager.getBaidu(new NetWorkListener() {
            @Override
            public void onResponse(String response) {
                assertNotNull(response);
                assertEquals("reeponse faild!","fail",response);
                latch.notify();
            }
        });
        latch.await();
    }

    @Test
    public void testGetAppName(){
        Context context = InstrumentationRegistry.getTargetContext();
        NetWorkManager netWorkManager = new NetWorkManager();
        assertNotNull(netWorkManager.getAppName(context));
        assertEquals("AndroidTestApplication",netWorkManager.getAppName(context));
    }

    @Test
    public void testGetSharedData(){
        Context context = InstrumentationRegistry.getTargetContext();
        NetWorkManager netWorkManager = new NetWorkManager();
        String test_shared_value = netWorkManager.getSharedData(context);
        assertNotNull(test_shared_value);
        assertEquals("test_shared_value",test_shared_value);
    }

}