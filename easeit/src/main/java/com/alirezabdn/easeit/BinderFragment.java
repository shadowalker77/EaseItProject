package com.alirezabdn.easeit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 10/16/2017.
 */

public abstract class BinderFragment extends Fragment {

    @BindStatus(BindStatus.Status.DO_NOT_BIND)
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView != null)
            return rootView;
        rootView = inflater.inflate(getLayoutId(), container, false);
        Binder.bind(getActivity(), this, rootView);
        Ease.easeIt(this, rootView);
        onCreate();
        return rootView;
    }

    protected <T extends View> T findViewById(int viewID) {
        return rootView.findViewById(viewID);
    }

    protected abstract int getLayoutId();

    protected void onCreate() {}
}
