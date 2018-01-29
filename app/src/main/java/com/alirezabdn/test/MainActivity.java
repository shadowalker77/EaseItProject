package com.alirezabdn.test;

import com.alirezabdn.easeit.State;
import com.alirezabdn.easeit.StateMachineCore;

public class MainActivity extends StateMachineCore {

    @Override
    protected void onCreate() {
        super.onCreate();
        addState(new State(new MainFragment()));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentContainer() {
        return R.id.container;
    }
}
