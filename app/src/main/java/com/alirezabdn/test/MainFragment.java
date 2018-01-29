package com.alirezabdn.test;

import android.widget.TextView;

import com.alirezabdn.easeit.BinderFragment;

/**
 * Created by shadoWalker on 1/29/18.
 */

public class MainFragment extends BinderFragment {

    private TextView tv;

    @Override
    protected void onCreate() {
        super.onCreate();
        tv.setText("Sample");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }
}
