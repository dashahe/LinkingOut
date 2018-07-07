package com.sao.utils;

import java.sql.Date;
import java.sql.Time;

public class SaoDateTime {
    private Date date;

    private Time time;

    public SaoDateTime(Date date, Time time) {
        this.date = date;
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
