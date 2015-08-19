package lai.com.projectl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by admin on 2015/8/19.
 */
public class MainItemFragment extends Fragment{

    private View mMainView;
    
    public static MainItemFragment getInstance() {
        MainItemFragment mainItemFragment = new MainItemFragment();
        return mainItemFragment;
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMainView = inflater.inflate(R.layout.fragment_main_item, null);
        Button btn = (Button) mMainView.findViewById(R.id.btn_test_bowen);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"测试按钮波纹效果",Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getActivity(),MaterialDesignThemeActivity.class);
                getActivity().startActivity(it);
            }
        });
        return mMainView;
    }
}
