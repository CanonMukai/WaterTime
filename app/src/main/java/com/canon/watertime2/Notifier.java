package com.canon.watertime2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.widget.Toast;

public class Notifier extends BroadcastReceiver {
    public final String TAG = Notifier.class.getName();

    @Override
    public void onReceive(Context content, Intent intent) {

        Log.d(TAG, "Notifier");
        Toast.makeText(content, "水！！", Toast.LENGTH_SHORT).show();

        NotificationCompat.Builder builder
                = new NotificationCompat.Builder(content, "CHANNEL_ID")
                .setSmallIcon(android.R.drawable.ic_menu_info_details)
                .setContentTitle("Water Time!")
                .setContentText("水を飲む時間です！！")
                .setVibrate(new long[]{0, 700, 10, 100, 2000, 700, 10, 100, 2000, 700, 10, 100})
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager
                = NotificationManagerCompat.from(content);

        notificationManager.notify(R.string.app_name, builder.build());

    }
}
