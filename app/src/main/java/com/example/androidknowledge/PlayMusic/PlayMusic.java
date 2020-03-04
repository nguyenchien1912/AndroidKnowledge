package com.example.androidknowledge.PlayMusic;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.androidknowledge.BaseActivity;
import com.example.androidknowledge.R;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;

public class PlayMusic extends BaseActivity {

    @BindView(R.id.image_play)
    ImageButton play;

    @BindView(R.id.image_backward)
    ImageButton backward;

    @BindView(R.id.image_forward)
    ImageButton forward;

    @BindView(R.id.time_music)
    SeekBar seekbar;



    private MediaPlayer mediaPlayer;

    private String s,m,valueS,valueM;
    private Handler myHandler = new Handler();
    private double startTime = 0;
    private double finalTime = 0;
    public static int oneTimeOnly = 0;
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_play_music;
    }

    @Override
    protected void setupListener() {
        creat();
        setImage();
        Play();
        setTime();
        MediaPlayerNext();


    }

    private void MediaPlayerNext() {
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.start();

            }
        });
    }

    @Override
    protected void populateData() {
        HideTitle();
    }

    private void setImage()
    {
        play.setBackground(null);
        backward.setBackground(null);
        forward.setBackground(null);
    }

    private void Play()
    {

        updateTime(0);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.play);

                }
                else
                {
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.pause);

                    startTime = mediaPlayer.getCurrentPosition();
                    finalTime = mediaPlayer.getDuration();
                    if (oneTimeOnly == 0) {
                        seekbar.setMax((int) finalTime);
                        oneTimeOnly = 1;
                    }

//                    seekbar.setProgress((int)startTime);
                    myHandler.postDelayed(UpdateSongTime,100);
                }
            }
        });

    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            finalTime = mediaPlayer.getDuration();

            updateTime((int) startTime);
            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };
    private void updateTime(int up)
    {


        s = String.format("%d",TimeUnit.MILLISECONDS.toSeconds((long) up) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) up)));
        if(Integer.parseInt(s)<=9)
        {
            s = "0" + s;
        }
        m = String.format("%d",
                TimeUnit.MILLISECONDS.toMinutes((long) up)
        );

        valueS = String.format("%d",TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime)));

        if (Integer.parseInt(valueS) <=9)
        {
            valueS = "0" + valueS;
        }
        valueM = String.format("%d",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime));

//        tvStartTime.setText(m + ":" + s + "/" + valueM + ":" + valueS);

        Drawable drawable = new TextDrawable.Builder()
                .setWidth(120)
                .setHeight(35)
                .setColor(Color.GREEN)
                .setShape(TextDrawable.SHAPE_ROUND_RECT)
                .setRadius(100)
                .setText(m + ":" + s + "/" + valueM + ":" + valueS)
                .setFontSize(23 )
                .build();
        seekbar.setThumb(drawable);

    }

    private void setTime()
    {

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int time = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                time = progress;
                updateTime(time);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(time);
            }
        });
    }

    private void creat()
    {
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this,R.raw.thuan_theo_y_troi );

    }
}
