package androidbuffer.com.musicbeats;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by incred-dev on 6/6/18.
 */

public class Util {

    public static void finishAndLunchActivity(Activity activity, Class<? extends Activity> classActivity){
        lunchActivity(activity,classActivity);
        activity.finish();
    }

    public static void lunchActivity(Activity activity, Class<? extends Activity> classActivity){
        Intent intent = new Intent(activity,classActivity);
        activity.startActivity(intent);
    }
}
