package com.alirezabdn.easeit.binder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alirezabdn.easeit.ease.Ease;

/**
 * Created by shadoWalker on 1/28/18.
 */

public abstract class BinderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            finish();
            startActivity(new Intent(this, this.getClass()));
        }
        setContentView(getLayoutId());
        Binder.bind(this, this, getMainLayout());
        Ease.easeIt(this, getMainLayout());
        onCreate();
    }

    protected View getMainLayout() {
        return findViewById(android.R.id.content);
    }

    protected abstract int getLayoutId();

    protected void onCreate() {}
}
