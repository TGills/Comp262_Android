package com.guillaume2127.multithreadingcounter;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView countTextView;
    private Integer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countTextView = (TextView) findViewById(R.id.textView1);
        count = 0;
        Thread thread = new Thread (countNumbers);
        thread.start();
    }

    @Override
    protected void onStart(){
        super.onStart();
        count = 0;
    }

    private Runnable countNumbers = new Runnable(){
        private static final int DELAY = 1000;
                public void run() {
                    try{
                        while (true){
                            count ++;
                            Thread.sleep (DELAY);
                            threadHandler.sendEmptyMessage(0);
                        }
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
    };

    public Handler threadHandler = new Handler(){
        public void handleMessage (android.os.Message message){
            countTextView.setText(count.toString());
        }
    };




/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(items);
    }
*/







}
