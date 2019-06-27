package com.example.haixl.androidtestapplication.util;

import java.util.Date;

/**
 * @author zhaosw.
 * @date 2019/2/22.
 */
public class CalendarHelper {

    private String today = null;

    public String flagToday(){
        Date date = new Date();
        this.today = date.getDate()+"";
        return this.today;
    }

}
