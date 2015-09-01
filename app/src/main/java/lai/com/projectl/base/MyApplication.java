package lai.com.projectl.base;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import lai.com.projectl.AppForegroundState.AppForegroundStateManager;

/**
 * Created by admin on 2015/9/1.
 */
public class MyApplication extends Application implements AppForegroundStateManager.OnAppForegroundStateChangeListener {

    @Override
    public void onCreate() {
        super.onCreate();
        AppForegroundStateManager.getInstance().addListener(this);
    }

    @Override
    public void onAppForegroundStateChange(AppForegroundStateManager.AppForegroundState newState) {
        if (AppForegroundStateManager.AppForegroundState.IN_FOREGROUND == newState) {
            // App just entered the foreground. Do something here!
            Log.e("MyApplication", "onAppForegroundStateChange--- entered the foreground");
            Toast.makeText(this, "onAppForegroundStateChange--- entered the foreground", Toast.LENGTH_SHORT);
        } else {
            // App just entered the background. Do something here!
            Log.e("MyApplication", "onAppForegroundStateChange--- out the foreground");
        }
    }
}
