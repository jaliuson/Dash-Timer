package com.example.my40prototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.PrintWriter;

public class FrontPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        try{
            PrintWriter pw = new PrintWriter("timed_results.txt");
            pw.close();
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Could not find text file", Toast.LENGTH_LONG).show();
        }
    }

    public void onClick(View V){
        Intent I = new Intent(this,MainScreen.class);
        startActivity(I);
    }
}
