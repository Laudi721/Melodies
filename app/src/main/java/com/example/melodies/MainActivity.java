package com.example.melodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    public static final int sound_Guitar1 = R.raw.guitar1;
    public static final int sound_Guitar2 = R.raw.guitar2;
    public static final int sound_Bass1 = R.raw.bass1;
    public static final int sound_Bass2 = R.raw.bass2;
    public static final int sound_Drums1 = R.raw.drums1;
    public static final int sound_Drums2 = R.raw.drums2;
    static final int READ_BLOCK_SIZE = 100;

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

    public void Write(View v)
    {

        try
        {
            FileOutputStream file_out = openFileOutput("clickHistory.txt", MODE_PRIVATE);
            OutputStreamWriter out_write = new OutputStreamWriter(file_out);
            out_write.write();
            out_write.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Read(View v)
    {
        try
        {
            FileInputStream file_in = openFileInput("clickHistory.txt");
            InputStreamReader input_read = new InputStreamReader(file_in);
            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String chain ="";
            int charRead;

            while((charRead = input_read.read(inputBuffer)) > 0)
            {
                String readString = String.copyValueOf(inputBuffer,0,charRead);
                chain += readString;
            }

            input_read.close();
            Toast.makeText(getBaseContext(), chain, Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}