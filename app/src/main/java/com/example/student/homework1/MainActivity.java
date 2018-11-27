package com.example.student.homework1;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer myPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_pause ) );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( myPlayer.isPlaying() ) {
                    ((FloatingActionButton)view).setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_play ) );
                    myPlayer.pause();
                }
                else {
                    ((FloatingActionButton)view).setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_pause ) );
                    myPlayer.start();
                }
            }
        });
        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data1 = new Intent(getApplicationContext(), Second_Activity.class);
                startActivityForResult( data1, 1 );
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data2 = new Intent(getApplicationContext(), Second_Activity.class);
                startActivityForResult( data2, 2 );
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data3 = new Intent(getApplicationContext(), Second_Activity.class);
                startActivityForResult( data3, 3 );
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            int v[] = data.getIntArrayExtra("color");
            Button BT1 = (Button)findViewById(R.id.btn1);
            Button BT2 = (Button)findViewById(R.id.btn2);
            Button BT3 = (Button)findViewById(R.id.btn3);

            switch (requestCode){
                case 1:
                    LinearLayout bg = (LinearLayout)findViewById(R.id.bg);
                    bg.setBackgroundColor(Color.rgb(v[0],v[1],v[2]));
                    break;
                case 2:
                    BT1.setBackgroundColor(Color.rgb(v[0],v[1],v[2]));
                    BT2.setBackgroundColor(Color.rgb(v[0],v[1],v[2]));
                    BT3.setBackgroundColor(Color.rgb(v[0],v[1],v[2]));
                    break;
                case 3:
                    BT1.setTextColor(Color.rgb(v[0],v[1],v[2]));
                    BT2.setTextColor(Color.rgb(v[0],v[1],v[2]));
                    BT3.setTextColor(Color.rgb(v[0],v[1],v[2]));
                    break;
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        myPlayer.pause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        myPlayer = MediaPlayer.create( this, R.raw.johncena );
        myPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                mp.start();
            }});
        ((FloatingActionButton)findViewById(R.id.fab)).setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_pause ) );
    }
    @Override
    protected void onStop() {
        super.onStop();
        myPlayer.release();
    }
}
