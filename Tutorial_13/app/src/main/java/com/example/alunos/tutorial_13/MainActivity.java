package com.example.alunos.tutorial_13;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private NotificationManager notificationManager;
    private NotificationCompat.Builder notificationBuilder;
    private final String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent resultIntent = new Intent(this, ResultActivity.class);
        PendingIntent resultPendingIntent = TaskStackBuilder.create(this).addNextIntentWithParentStack(resultIntent).getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    notificationBuilder = new NotificationCompat.Builder(
            this, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setContentTitle("Uma notificação")
            .setontentText("Exemplo de notificação interna.")
            .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
            .setVibrate(new long[]{1000,1000})
            .setAutoCancel(true);
    notificationBuilder.setContentIntent(resultPedingIntent);
    notificationManager = (notificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

   button notif = findViewById(R.id.btnNotif);
    notif.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view){
            notificationManager.notify(0, notificationBuilder.build());
        }
    });
}
