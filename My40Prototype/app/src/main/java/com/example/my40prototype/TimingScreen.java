package com.example.my40prototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TimingScreen extends Activity {
    DashTimer timer;
    File outputFile;
    BufferedWriter bw;

    public TimingScreen() {
        try{
            Intent intent = getIntent();
            //timer = intent.getStringExtra("stored_results");
        }
        catch(Exception e){

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing_screen);
    }

    public void onRelease(View V) {
        V.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:// PRESSED - No effect
                        return false;
                    case MotionEvent.ACTION_UP: // RELEASED - timer started
                        Toast.makeText(getApplicationContext(), "Timer started", Toast.LENGTH_LONG).show();
                        timer = new DashTimer();
                        setContentView(R.layout.activity_timing_screen_2);
                }
                return false;
            }
        });
    }

    public void onStopPress(View V) {
        System.out.println("X");
        timer.stop();
        //MainScreen.data.storeResult(timer.getTime());
        try{
            outputFile = new File("timed_results.txt");
            bw = new BufferedWriter(new FileWriter(outputFile));
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Could not find text file", Toast.LENGTH_LONG).show();
        }
        System.out.println(timer.getTime());
        Toast.makeText(getApplicationContext(), Double.toString(timer.getTime()), Toast.LENGTH_LONG).show();
        Intent I = new Intent(this,MainScreen.class);
        startActivity(I); //takes back to main page
    }
}
