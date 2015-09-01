package lai.com.projectl.CustomView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lai.com.projectl.CustomView.library.CustomProgressBar;
import lai.com.projectl.R;
import lai.com.projectl.base.BaseActivity;

/**
 * Created by admin on 2015/8/24.
 */
public class CustomProgressBarTestActivity extends BaseActivity {

    private CustomProgressBar mCustomProgressBar;
    private Button mStopProgressBar;
    private Button mStartProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_progressbar);
        mStartProgressBar = (Button) findViewById(R.id.btnStartProgressBar);
        mStopProgressBar = (Button) findViewById(R.id.btnStopProgressBar);
        mCustomProgressBar = (CustomProgressBar) findViewById(R.id.btn_CustomProgressBar);
        mStartProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomProgressBar.setStopProgressBar(false);
            }
        });
        mStopProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomProgressBar.setStopProgressBar(true);
            }
        });
    }


}
