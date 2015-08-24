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

import lai.com.projectl.CustomView.CustomImageViewTestActivity;
import lai.com.projectl.CustomView.CustomProgressBarTestActivity;
import lai.com.projectl.CustomView.CustomTitleView;
import lai.com.projectl.CustomView.CustomTitleViewTestActivity;
import lai.com.projectl.PagerSlidingTabStrip.sample.*;
import lai.com.projectl.RecyclerViewSwipeDismiss.SwipeDismissRecyclerViewActivity;

/**
 * Created by admin on 2015/8/19.
 */
public class MainItemFragment extends Fragment {

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
                Intent it = new Intent(getActivity(), MaterialDesignThemeActivity.class);
                getActivity().startActivity(it);
            }
        });
        Button btn_swipe_dismiss = (Button) mMainView.findViewById(R.id.btn_swipe_dismiss);
        btn_swipe_dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), SwipeDismissRecyclerViewActivity.class);
                getActivity().startActivity(it);
            }
        });
        Button btn_PagerSlidingStrip = (Button) mMainView.findViewById(R.id.btn_PagerSlidingStrip);
        btn_PagerSlidingStrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), lai.com.projectl.PagerSlidingTabStrip.sample.MainActivity.class);
                getActivity().startActivity(it);
            }
        });
        Button btn_CustomTtileView = (Button) mMainView.findViewById(R.id.btn_CustomTtileView);
        btn_CustomTtileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), CustomTitleViewTestActivity.class);
                getActivity().startActivity(it);
            }
        });
        Button btn_CustomImageView = (Button) mMainView.findViewById(R.id.btn_CustomImageView);
        btn_CustomImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), CustomImageViewTestActivity.class);
                getActivity().startActivity(it);
            }
        });

        Button btn_CustomProgressBar = (Button) mMainView.findViewById(R.id.btn_CustomProgressBar);
        btn_CustomProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), CustomProgressBarTestActivity.class);
                getActivity().startActivity(it);
            }
        });
        Button btn_GoogleCustomView = (Button) mMainView.findViewById(R.id.btn_GoogleCustomView);
        btn_GoogleCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(it);
            }
        });
        return mMainView;
    }
}
