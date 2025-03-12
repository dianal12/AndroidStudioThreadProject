package com.example.thread;

import android.widget.TextView;

import java.util.Calendar;

public class MyThread extends Thread{
    private TextView textView;

    public MyThread(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void run() {
        while (true) {
            Calendar calendar = Calendar.getInstance();
            String time = String.valueOf(calendar.getTime());
            textView.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText(time);
                }
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
