package com.canon.watertime2;

import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick");

                //呼び出す日時を設定する
                Calendar triggerTime = Calendar.getInstance();
                triggerTime.add(Calendar.HOUR, 1);	//今から5秒後

                //設定した日時で発行するIntentを生成
                Intent intent = new Intent(MainActivity.this, Notifier.class);
                PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager manager = (AlarmManager)getSystemService(ALARM_SERVICE);
                manager.set(AlarmManager.RTC_WAKEUP, triggerTime.getTimeInMillis(), sender);
            }

        });
    }
}
