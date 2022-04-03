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
    public static final int sound_Bass1 = R.raw.bass1;
    public static final int sound_Bass2 = R.raw.bass2;
    public static final int sound_Drums1 = R.raw.drums1;
    public static final int sound_Drums2 = R.raw.drums2;

    public Button Guitar1;
    public Button Guitar2;
    public Button Bass1;
    public Button Bass2;
    public Button Drums1;
    public Button Drums2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Guitar1 = (Button) findViewById(R.id.button2);
        Guitar2 = (Button) findViewById(R.id.button4);
        Bass1 = (Button) findViewById(R.id.button5);
        Bass2 = (Button) findViewById(R.id.button7);
        Drums1 = (Button) findViewById(R.id.button3);
        Drums2 = (Button) findViewById(R.id.button6);

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
            Guitar1.setBackgroundColor(0xff00ff00);

            Guitar2.setBackgroundColor(0xffff0000);
            Bass1.setBackgroundColor(0xffff0000);
            Bass2.setBackgroundColor(0xffff0000);
            Drums1.setBackgroundColor(0xffff0000);
            Drums2.setBackgroundColor(0xffff0000);

        }
        else if(Guitar2.getId() == v.getId())
        {
            sound = sound_Guitar2;
            Guitar2.setBackgroundColor(0xff00ff00);

            Guitar1.setBackgroundColor(0xffff0000);
            Bass1.setBackgroundColor(0xffff0000);
            Bass2.setBackgroundColor(0xffff0000);
            Drums1.setBackgroundColor(0xffff0000);
            Drums2.setBackgroundColor(0xffff0000);
        }
        else if(Bass1.getId() == v.getId())
        {
            sound = sound_Bass1;
            Bass1.setBackgroundColor(0xff00ff00);

            Guitar1.setBackgroundColor(0xffff0000);
            Guitar2.setBackgroundColor(0xffff0000);
            Bass2.setBackgroundColor(0xffff0000);
            Drums1.setBackgroundColor(0xffff0000);
            Drums2.setBackgroundColor(0xffff0000);
        }
        else if(Bass2.getId() == v.getId())
        {
            sound = sound_Bass2;
            Bass2.setBackgroundColor(0xff00ff00);

            Guitar1.setBackgroundColor(0xffff0000);
            Guitar2.setBackgroundColor(0xffff0000);
            Bass1.setBackgroundColor(0xffff0000);
            Drums1.setBackgroundColor(0xffff0000);
            Drums2.setBackgroundColor(0xffff0000);
        }
        else if(Drums1.getId() == v.getId())
        {
            sound = sound_Drums1;
            Drums1.setBackgroundColor(0xff00ff00);

            Guitar1.setBackgroundColor(0xffff0000);
            Guitar2.setBackgroundColor(0xffff0000);
            Bass1.setBackgroundColor(0xffff0000);
            Bass2.setBackgroundColor(0xffff0000);
            Drums2.setBackgroundColor(0xffff0000);
        }
        else if(Drums2.getId() == v.getId())
        {
            sound = sound_Drums2;
            Drums2.setBackgroundColor(0xff00ff00);

            Guitar1.setBackgroundColor(0xffff0000);
            Guitar2.setBackgroundColor(0xffff0000);
            Bass1.setBackgroundColor(0xffff0000);
            Bass2.setBackgroundColor(0xffff0000);
            Drums1.setBackgroundColor(0xffff0000);
        }

        playSound(this, sound);
    }
}