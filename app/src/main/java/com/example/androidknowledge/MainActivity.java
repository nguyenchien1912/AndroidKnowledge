package com.example.androidknowledge;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;

import com.example.androidknowledge.Intent.IntentActivity;
import com.example.androidknowledge.PlayMusic.PlayMusic;
import com.example.androidknowledge.SaveData.InternalStorage;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.notificationwindow)
    Button notification;

    @BindView(R.id.viewadvanced)
    Button viewadvanced;

    @BindView(R.id.intent)
    Button intent;

    @BindView(R.id.exit)
    Button exit;

    @BindView(R.id.test_menu)
    TextView testmenu;

    @BindView(R.id.save_data)
    Button savedata;

    @BindView(R.id.play_music)
    Button playmusic;
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupListener() {

        Notification();
        ViewAdvanced();
        TestIntent();
        SaveData();
        playMusic();
        Exit();

    }


    @Override
    protected void populateData() {
        setTitle();
    }

    private void Notification()
    {
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NotificationManage.class));
            }
        });
    }

    private void ViewAdvanced()
    {
        viewadvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ViewManage.class));
            }
        });
    }

    private void Exit()
    {
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Question ?");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("are you sure you want to exit");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.search :
                testmenu.setText("test search");
                break;
            case R.id.share :
                testmenu.setText("test share");
                break;
            case R.id.setting :
                testmenu.setText("test setting");
                break;
            case R.id.about :
                testmenu.setText("test about");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void TestIntent() {
        intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IntentActivity.class));
            }
        });
    }

    private void SaveData() {
        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InternalStorage.class));
            }
        });
    }

    private void playMusic()
    {
        playmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlayMusic.class));
            }
        });
    }

    private void setTitle()
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("MeMenu");
    }
}