package vthomas13.musicq_phase2;

/**
 * Created by vthomas13 on 4/13/2016.
 */
import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeIntents;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.squareup.picasso.Picasso;
import android.content.Intent;
import android.drm.DrmStore;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.net.URI;

import static vthomas13.musicq_phase2.R.string.*;

public class YTActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ytactivity);
        ImageView imgView = (ImageView) findViewById(R.id.imageView);
        setPicture(imgView, Uri.parse("https://i.ytimg.com/vi_webp/s_a1hPwXiWw/default.webp"));
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);


    }
    public void setPicture(ImageView imgView, Uri uri){
//        imgView.setImageURI(uri);

        Picasso.with(this).load(uri).into(imgView);
    }

    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
           switch (MainActivity.i){
                    case 1:
                        indiePlaylist(player);
                        break;
                    case 2:
                        hiphopPlaylist(player);
                        break;
                    case 3:
                        rockPlaylist(player);
                        break;
                    case 4:
                        electronicPlaylist(player);
                        break;
                    case 5:
                        countryPlaylist(player);
                        break;
                    case 6:
                        popPlaylist(player);
                        break;
           }
        }
    }

    public static void indiePlaylist (YouTubePlayer player){

        player.loadPlaylist("PLSn1U7lJJ1UkPrOvoAb6UVRIbJeygpCma");
    }
    public static void rockPlaylist (YouTubePlayer player){

        player.loadPlaylist("PLhd1HyMTk3f5S98HGlByL2eH1T3n6J-bR");
    }
    public static void hiphopPlaylist (YouTubePlayer player){

        player.loadPlaylist("PLH6pfBXQXHEBElcVFl-gGewA2OaATF4xL");
    }
    public static void electronicPlaylist (YouTubePlayer player){

        player.loadPlaylist("PLFPg_IUxqnZNTAbUMEZ76_snWd-ED5en7");
    }
    public static void countryPlaylist (YouTubePlayer player){

        player.loadPlaylist("PLvLX2y1VZ-tHnQyOqyemaWjZjrJYr8ksp");
    }
    public static void popPlaylist (YouTubePlayer player){

        player.loadPlaylist("PLDcnymzs18LWbmCFUlZie7VsxQ_FIF0_y");
    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    public void initialize (String developerKey, YouTubeThumbnailView.OnInitializedListener onInitializedlistener){
    }
    protected Provider getYouTubePlayerProvider() {
        return youTubeView;
    }



}
