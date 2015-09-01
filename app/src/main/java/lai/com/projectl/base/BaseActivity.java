package lai.com.projectl.base;

import android.support.v7.app.AppCompatActivity;

import lai.com.projectl.AppForegroundState.AppForegroundStateManager;

/**
 * Created by admin on 2015/9/1.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        AppForegroundStateManager.getInstance().onActivityVisible(this);
    }

    @Override
    protected void onStop() {
        AppForegroundStateManager.getInstance().onActivityNotVisible(this);
        super.onStop();
    }
}
