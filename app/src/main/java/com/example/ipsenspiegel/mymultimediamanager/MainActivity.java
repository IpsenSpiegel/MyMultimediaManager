package com.example.ipsenspiegel.mymultimediamanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG_MAIN_ACTIVITY = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button play_Btn = (Button) this.findViewById(R.id.btnPlayTrack);
        play_Btn.setOnClickListener(this);
        final Button stop_Btn = (Button) this.findViewById(R.id.btnStopTrack);
        stop_Btn.setOnClickListener(this);
        final Button sound_Btn = (Button) this.findViewById(R.id.btnPlaySound);
        sound_Btn.setOnClickListener(this);
        final Button playInService_Btn = (Button) this.findViewById(R.id.btnPlaySoundInService);
        playInService_Btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View whichView) {
        if (whichView.getId() == R.id.btnPlayTrack) {

        } else if (whichView.getId() == R.id.btnStopTrack) {

        } else if (whichView.getId() == R.id.btnPlaySound) {

        } else if (whichView.getId() == R.id.btnPlaySoundInService) {
        }
    }
}