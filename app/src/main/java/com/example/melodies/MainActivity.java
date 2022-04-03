package com.example.melodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int sound_Guitar1 = R.raw.guitar1;
    public static final int sound_Guitar2 = R.raw.guitar2;
    public static final int sound_Bass = R.raw.bass;
    public static final int sound_Drums = R.raw.drums;

    Button Guitar1;
    Button Guitar2;
    Button Bass;
    Button Drums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Guitar1 = (Button) findViewById(R.id.button2);
        Guitar2 = (Button) findViewById(R.id.button4);
        Bass = (Button) findViewById(R.id.button5);
        Drums = (Button) findViewById(R.id.button3);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            // ok TODO
        }
        else
        {
            Toast.makeText(this, "Stary ten system", Toast.LENGTH_LONG).show();
        }
    }

    public void playSound(Context context, int soundID)
    {
        MediaPlayer mp = MediaPlayer.create(context, soundID);
        mp.start();
    }

    public void play(View v)
    {
        int sound = 0;

        if(Guitar1.getId() == v.getId())
        {
            sound = sound_Guitar1;
        }
        else if(Drums.getId() == v.getId())
        {
            sound = sound_Drums;
        }

        playSound(this, sound);
    }
}