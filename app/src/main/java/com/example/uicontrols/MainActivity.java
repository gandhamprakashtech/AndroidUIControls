package com.example.uicontrols;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {

    private TextView tvDate, tvTime, tvWelcome;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);

        Button btnGoForm = findViewById(R.id.btnGoForm);

        // Set Date
        tvDate.setText(new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date()));

        // Update Time Continuously
        Runnable updateTime = new Runnable() {
            @Override
            public void run() {
                tvTime.setText(new SimpleDateFormat("hh:mm:ss a", Locale.getDefault()).format(new Date()));
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(updateTime);



        // Button → Open next activity
        btnGoForm.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, activity2.class))
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null); // stop time updates
    }
}
