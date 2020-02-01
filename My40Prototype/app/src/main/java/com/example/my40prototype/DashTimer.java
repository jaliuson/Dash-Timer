package com.example.my40prototype;

public class DashTimer {
    long start;
    double totalTime;
    public DashTimer(){
        start = System.currentTimeMillis();
    }
    public void stop(){
        long now = System.currentTimeMillis();
        totalTime = (now - start) / 1000.0;
    }
    public double getTime(){
        return totalTime;
    }
}

