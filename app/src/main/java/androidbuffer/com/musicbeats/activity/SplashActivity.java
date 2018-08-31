package androidbuffer.com.musicbeats.activity;

import android.os.Bundle;
import android.os.Handler;

import androidbuffer.com.musicbeats.R;
import androidbuffer.com.musicbeats.Util;

/**
 * Created by incred-dev on 6/6/18.
 */

public class SplashActivity extends BaseActivity {

    private final int SPLASH_DISPLAY_TIME_IN_MS = 2000;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goNext();
            }
        },SPLASH_DISPLAY_TIME_IN_MS);
    }

    private void goNext(){
        Util.finishAndLunchActivity(SplashActivity.this,MainActivity.class);
    }
}
