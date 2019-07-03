package com.example.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int max=50,min=1,times=20;

    public void createTable(int times){

        ArrayList<String> table = new ArrayList<String>();

        for(int i =1;i<=10;i++)
            table.add(Integer.toString(i*times));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_activated_1,table);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        listView = findViewById(R.id.timesTable);

        seekBar.setMax(max);
        seekBar.setProgress(times);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress<min)
                {
                    seekBar.setProgress(min);
                    progress=min;
                }

                    times=progress;

                createTable(times);
              //  Log.i("Seekbar value ", Integer.toString(times));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        createTable(times);

    }
}
