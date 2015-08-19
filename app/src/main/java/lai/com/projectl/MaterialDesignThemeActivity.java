package lai.com.projectl;

import android.app.Activity;
import android.os.Bundle;

/**
 * 2、Material Design的Theme
    md的主题有：
 
    @android:style/Theme.Material (dark version)
    @android:style/Theme.Material.Light (light version)
    @android:style/Theme.Material.Light.DarkActionBar
    与之对应的Compat Theme:
    
    Theme.AppCompat
    Theme.AppCompat.Light
    Theme.AppCompat.Light.DarkActionBar
 * 
 * Created by admin on 2015/8/19.
 */
public class MaterialDesignThemeActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design_theme);
    }
    
    
}
