package vthomas13.musicq_phase2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import vthomas13.musicq_phase2.YTActivity;

import com.google.android.youtube.player.YouTubePlayer;

public class MainActivity extends AppCompatActivity{
    public static String genre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button indieBtn = (Button)findViewById(R.id.indie);
        indieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genre = "indie";
                startActivity(new Intent(MainActivity.this, YTActivity.class));
            }
        });
        Button rockBtn = (Button)findViewById(R.id.rock);
        rockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genre = "rock";
                startActivity(new Intent(MainActivity.this, YTActivity.class));
            }
        });
        Button hiphopBtn = (Button)findViewById(R.id.hiphop);
        hiphopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genre = "hiphop";
                startActivity(new Intent(MainActivity.this, YTActivity.class));
            }
        });
        Button edmBtn = (Button)findViewById(R.id.electronic);
        edmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genre = "edm";
                startActivity(new Intent(MainActivity.this, YTActivity.class));
            }
        });
        Button countryBtn = (Button)findViewById(R.id.country);
        countryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genre = "country";
                startActivity(new Intent(MainActivity.this, YTActivity.class));
            }
        });
        Button popBtn = (Button)findViewById(R.id.pop);
        popBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genre = "pop";
                startActivity(new Intent(MainActivity.this, YTActivity.class));
            }
        });


    }
}
