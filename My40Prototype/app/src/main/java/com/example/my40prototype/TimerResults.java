package com.example.my40prototype;

import java.util.ArrayList;

public class TimerResults {
    ArrayList<String> IDarr;
    ArrayList<String> Tarr;
    static int resultsNumber;
    public TimerResults(){
        IDarr = new ArrayList<String>();
        Tarr = new ArrayList<String>();
        resultsNumber = 1;
    }
    public void storeResult(double time){
        IDarr.add(0,"Test #" + resultsNumber);
        Tarr.add(0 ,Double.toString(time));
        resultsNumber++;
    }
    public String getResultID(int position){ //@TODO problem, change around, build into the dashtimer or timing screen
        return(IDarr.get(position));
    }
    public String getResultTime(int position){
        return(Tarr.get(position));
    }
    public boolean isEmpty(){
        if(IDarr.size() == 0)
            return true;
        else
            return false;
    }
}
