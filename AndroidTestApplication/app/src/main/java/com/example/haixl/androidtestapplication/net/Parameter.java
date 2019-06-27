package com.example.haixl.androidtestapplication.net;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaosw.
 * @date 2019/2/26.
 */
public class Parameter {

    public static Parameter getInstance(){
        return ParameterHolder.instance;
    }

    public String getUrl(String key){
        return urlMap.get(key);
    }

    private static class ParameterHolder{
        private static Parameter instance = new Parameter();
    }

    private static Map<String,String> urlMap = new HashMap<>();

    {
        urlMap.put(Key.BAIDU,Value.BAIDU);
        urlMap.put(Key.SOHU,Value.SOHU);
    }

    public static class Key{
        static String BAIDU = "baidu";
        static String SOHU = "sohu";
    }

    public static class Value {
        static String BAIDU = "https://www.baidu.com";
        static String SOHU = "http://www.sohu.com";
    }

}
