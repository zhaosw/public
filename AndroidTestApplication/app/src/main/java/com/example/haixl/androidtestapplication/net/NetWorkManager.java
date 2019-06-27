package com.example.haixl.androidtestapplication.net;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.haixl.androidtestapplication.R;
import com.example.haixl.androidtestapplication.util.ThreadPoolManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * @author zhaosw.
 * @date 2019/2/26.
 */
public class NetWorkManager {

    private OkHttpClient okHttpClient = null;

    private OkHttpClient getOkHttpClient(){
        if(null == okHttpClient){
            okHttpClient = new OkHttpClient.Builder().readTimeout(5,TimeUnit.SECONDS).
                    connectTimeout(5,TimeUnit.SECONDS).writeTimeout(5,TimeUnit.SECONDS).build();
        }
        return okHttpClient;
    }

    public String getUrl(String key){
        return Parameter.getInstance().getUrl(key);
    }

    public void getBaidu(final NetWorkListener netWorkListener){
        Request request = new Request.Builder().url(getUrl(Parameter.Key.BAIDU)).get().build();
        getOkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                netWorkListener.onResponse("faild");
            }

            @Override
            public void onResponse(Call call, Response response)  {
                if(null != response){
                    if (response.isSuccessful()) {
                        netWorkListener.onResponse("success");
                        return;
                    }
                }
                netWorkListener.onResponse("faild");
            }
        });
    }

    public void getUserBeheaviorAsync(final NetWorkListener netWorkListener){
        ThreadPoolManager.getInstance().addThreadTask(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                netWorkListener.onResponse("success");
            }
        });
    }

    public void getUserBeheaviorAsyncT(final NetWorkListener netWorkListener){
//        Thread thread = new Thread()
        ThreadPoolManager.getInstance().addThreadTask(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                netWorkListener.onResponse("success");
            }
        });
    }

    public String getAppName(Context context){
        return context.getString(R.string.app_name);
    }

    public String getSharedData(Context context){
        SharedPreferences sharedPreferences =
                context.getSharedPreferences("test_shared",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("shared_key","test_shared_value");
        editor.commit();
        return sharedPreferences.getString("shared_key",null);
    }

}
