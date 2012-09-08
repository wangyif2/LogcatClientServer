package com.example;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Robert
 * Date: 5/27/12
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class TimeStamp {
    private Date timeStamp;


    public TimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }


    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
