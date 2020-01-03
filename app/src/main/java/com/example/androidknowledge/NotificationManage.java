package com.example.androidknowledge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.example.androidknowledge.NotificationWindow.CreatNotification;
import com.example.androidknowledge.NotificationWindow.Information;
import com.example.androidknowledge.NotificationWindow.Login;

public class NotificationManage extends AppCompatActivity {
    Button takeinfo,tologin,creatnotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_window);
        findid();

        takeinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotificationManage.this, Information.class));
            }
        });

        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationManage.this, Login.class));
            }
        });

        creatnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationManage.this, CreatNotification.class));
            }
        });

    }
    private void findid()
    {
        takeinfo = (Button) findViewById(R.id.takeinformation);
        tologin = (Button) findViewById(R.id.tologin);
        creatnotification = (Button) findViewById(R.id.creatnotification);
    }

}
