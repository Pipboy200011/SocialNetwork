package com.mw2c.pipboy200011.socialnetwork.presentation.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mw2c.pipboy200011.socialnetwork.R;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.splash.SplashInjector;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.SplashPresenter;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity implements ISplashView {

    @Inject
    SplashPresenter mSplashPresenter;

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
        super.onDestroy();
        if (isFinishing()) {
            SplashInjector.cancelSplashComponent();
        }
    }

    @Override
    public void successConnect() {
        startActivity(LoginActivity.newInstance(this));
        finish();
    }
}
