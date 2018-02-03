package com.mw2c.pipboy200011.socialnetwork.presentation.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mw2c.pipboy200011.socialnetwork.R;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.splash.SplashInjector;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.ISplashPresenter;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity implements ISplashView {

    @Inject
    ISplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        SplashInjector.getSplashComponent().inject(this);
        mSplashPresenter.bindView(this);
        mSplashPresenter.downloadSomethingImportant();
    }

    @Override
    protected void onDestroy() {
        mSplashPresenter.unbindView();
        super.onDestroy();
    }

    @Override
    public void updateResult(Boolean result) {
        Toast.makeText(this, "Update success", Toast.LENGTH_LONG).show();
    }
}
