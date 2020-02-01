package com.example.my40prototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainScreen extends Activity {
    static TimerResults data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        data = new TimerResults();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        FloatingActionButton fab = findViewById(R.id.fab);

        String[] IDs = new String[3];
        String[] Times = new String[3];

        //**************POSTING RESULTS***************************
        try {
            IDs[0] = data.getResultID(0);
            Times[0] = data.getResultTime(0);
        }
        catch(Exception e){
            for(int i = 0 ; i < 3 ; i++){
                IDs[i] = "Empty";
                Times[i] = "--:----";
            }
        }
        try {
            IDs[1] = data.getResultID(1);
            Times[1] = data.getResultTime(1);
        }
        catch(Exception e){
            for(int i = 1 ; i < 3 ; i++){
                IDs[i] = "Empty";
                Times[i] = "--:----";
            }
        }
        try{
            IDs[2] = data.getResultID(2);
            Times[2] = data.getResultTime(2);
        }
        catch(Exception e){
            for(int i = 2 ; i < 3 ;i++){
                IDs[i] = "Empty";
                Times[i] = "--:----";
            }
        }
        //************************************************************


        TextView ID1 = (TextView) findViewById(R.id.first_id);
        TextView T1 = (TextView) findViewById(R.id.first_time);
        TextView ID2 = (TextView) findViewById(R.id.second_id);
        TextView T2 = (TextView) findViewById(R.id.second_time);
        TextView ID3 = (TextView) findViewById(R.id.third_id);
        TextView T3 = (TextView) findViewById(R.id.third_time);
        ID1.setText(IDs[0]);
        T1.setText(Times[0]);
        ID2.setText(IDs[1]);
        T2.setText(Times[1]);
        ID3.setText(IDs[2]);
        T3.setText(Times[2]);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                startActivity(new Intent(MainScreen.this,TimingScreen.class));
            }
        });
    }

    //static TimerResults pastResults = new TimerResults();

}
