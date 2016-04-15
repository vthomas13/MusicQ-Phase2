package vthomas13.musicq_phase2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubePlayer;

public class MainActivity extends AppCompatActivity{
    public static int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button indieBtn = (Button)findViewById(R.id.indie);
        indieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1;
                startActivity(new Intent(MainActivity.this, YTActivity.class));
            }
        });
        Button rockBtn = (Button)findViewById(R.id.rock);
        rockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                startActivity(new Intent(MainActivity.this, YTActivity.class));
            }
        });
        Button hiphopBtn = (Button)findViewById(R.id.hiphop);
        hiphopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=3;
                startActivity(new Intent(MainActivity.this, YTActivity.class));
            }
        });
        Button edmBtn = (Button)findViewById(R.id.electronic);
        edmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=4;
                startActivity(new Intent(MainActivity.this, YTActivity.class));
            }
        });
        Button countryBtn = (Button)findViewById(R.id.country);
        countryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=5;
                startActivity(new Intent(MainActivity.this, YTActivity.class));
            }
        });
        Button popBtn = (Button)findViewById(R.id.pop);
        popBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=6;
                startActivity(new Intent(MainActivity.this, YTActivity.class));
            }
        });


    }
}
