package edu.iis.mto.time;

import org.joda.time.DateTime;


public class TimeData {

    private DateTime time;

    public DateTime getTime() {
        return time;
    }

    public TimeData() {
        time = DateTime.now();
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public TimeData(DateTime time) {
        this.time = time;
    }
}
