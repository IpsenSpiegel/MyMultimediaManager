package com.example.ipsenspiegel.mymultimediamanager;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener {

    private static final String TAG_MAIN_ACTIVITY = "Main_Activity";
    private MediaPlayer mPlayer;
    private Button play_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.play_Btn = (Button) this.findViewById(R.id.btnPlayTrack);
        play_Btn.setOnClickListener(this);
        final Button stop_Btn = (Button) this.findViewById(R.id.btnStopTrack);
        stop_Btn.setOnClickListener(this);
        final Button sound_Btn = (Button) this.findViewById(R.id.btnPlaySound);
        sound_Btn.setOnClickListener(this);
        final Button playInService_Btn = (Button) this.findViewById(R.id.btnPlaySoundInService);
        playInService_Btn.setOnClickListener(this);

        this.mPlayer = MediaPlayer.create(this, R.raw.bensoundbrazilsamba);
    }

    @Override
    public void onClick(View whichView) {
        if (whichView.getId() == R.id.btnPlayTrack) {

            if (this.mPlayer.isPlaying()) {
                Log.i(MainActivity.TAG_MAIN_ACTIVITY, "Track stopped");
                this.mPlayer.stop();
                this.play_Btn.setText("Start");
            }
            else{
                Log.d(MainActivity.TAG_MAIN_ACTIVITY, "Playing track");
                this.mPlayer.start();
                this.play_Btn.setText("Pause");
            }

        } else if (whichView.getId() == R.id.btnStopTrack) {
            if (this.mPlayer.isPlaying()) {
                this.mPlayer.stop();
            }
        } else if (whichView.getId() == R.id.btnPlaySound) {


        } else if (whichView.getId() == R.id.btnPlaySoundInService) {
            Intent serviceIntent = new Intent(this, MyIntentService.class);
            this.startService(serviceIntent);

        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if (this.isFinishing())
        {
            this.mPlayer.stop();
            // Releasing the 'MediaPlayer'
            this.mPlayer.release();
            this.mPlayer = null;
        }

    }

    @Override
    public void onPrepared(MediaPlayer mp)
    {
        mp.start();
    }
}