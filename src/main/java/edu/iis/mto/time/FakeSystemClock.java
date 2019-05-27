package edu.iis.mto.time;

import org.joda.time.DateTime;


public class FakeSystemClock {

    private DateTime time;

    public DateTime getTime() {
        return time;
    }

    public FakeSystemClock() {
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public FakeSystemClock(DateTime time) {
        this.time = time;
    }
}
