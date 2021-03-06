package vthomas13.musicq_phase2;

/**
 * Created by vthomas13 on 4/13/2016.
 */
import com.squareup.picasso.Picasso;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailView;
import static vthomas13.musicq_phase2.R.string.*;

public class YTActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    public final String indieKey= "PLSn1U7lJJ1UkPrOvoAb6UVRIbJeygpCma";
    private String rockKey= "PLhd1HyMTk3f5S98HGlByL2eH1T3n6J-bR";
    private String hiphopKey= "PLH6pfBXQXHEBElcVFl-gGewA2OaATF4xL";
    private String edmKey= "PLFPg_IUxqnZNTAbUMEZ76_snWd-ED5en7";
    private String countryKey= "PLvLX2y1VZ-tHnQyOqyemaWjZjrJYr8ksp";
    private String popKey= "PLDcnymzs18LWbmCFUlZie7VsxQ_FIF0_y";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ytactivity);
//        ImageView imgView = (ImageView) findViewById(R.id.imageView); //commented thumbail
//        setPicture(imgView, Uri.parse("https://i.ytimg.com/vi_webp/s_a1hPwXiWw/default.webp"));
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);


    }
    public void setPicture(ImageView imgView, Uri uri){
        Picasso.with(this).load(uri).into(imgView);
    }

    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
           switch (MainActivity.genre){
                    case "indie":
                        startPlaylist(player, indieKey);
                        break;
                    case "rock":
                        startPlaylist(player, rockKey);
                        break;
                    case "hiphop":
                        startPlaylist(player, hiphopKey);
                        break;
                    case "edm":
                        startPlaylist(player, edmKey);
                        break;
                    case "country":
                        startPlaylist(player, countryKey );
                        break;
                    case "pop":
                        startPlaylist(player, popKey);
                        break;
               default:
           }
        }
    }
    public static void startPlaylist (YouTubePlayer player, String key){
        player.loadPlaylist(key);
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
