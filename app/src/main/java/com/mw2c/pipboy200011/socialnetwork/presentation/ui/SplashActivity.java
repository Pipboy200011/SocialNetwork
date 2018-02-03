package com.mw2c.pipboy200011.socialnetwork.presentation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mw2c.pipboy200011.socialnetwork.R;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.splash.SplashInjector;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.SplashPresenter;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.view.ISplashView;

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
        mSplashPresenter.unbindView();
        mSplashPresenter.destroyPresenter();
        super.onDestroy();
        if (isFinishing()) {
            SplashInjector.cancelSplashComponent();
        }
    }

    @Override
    public void updateResult(Boolean result) {
        Toast.makeText(this, "Update success", Toast.LENGTH_LONG).show();
        Intent intent = LoginActivity.newIntent(this);
        startActivity(intent);
        finish();
    }
}
