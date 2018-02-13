package com.mw2c.pipboy200011.socialnetwork.presentation.presenter;

import android.util.Log;

import com.mw2c.pipboy200011.socialnetwork.domain.SplashInteractor;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.ISplashView;
import com.mw2c.pipboy200011.socialnetwork.utils.rx.IRxSchedulersUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.Disposable;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public class SplashPresenter extends BasePresenter<ISplashView> {

    private static final String TAG = "SplashPresenter";

    private final SplashInteractor mSplashInteractor;
    private final IRxSchedulersUtils mRxSchedulersUtils;

    private Disposable mDownloadSomethingImportantDisposable;

    public SplashPresenter(SplashInteractor interactor,
                           IRxSchedulersUtils rxSchedulersUtils) {
        mSplashInteractor = interactor;
        mRxSchedulersUtils = rxSchedulersUtils;
    }

    @Override
    public void destroyPresenter() {
        cancelDownloadSomethingImportant();
    }

    public void downloadSomethingImportant() {
        mDownloadSomethingImportantDisposable = mSplashInteractor.downloadSomethingImportant()
                .delay(2, TimeUnit.SECONDS)
                .subscribeOn(mRxSchedulersUtils.getIOScheduler())
                .observeOn(mRxSchedulersUtils.getMainThreadScheduler())
                .subscribe((result, throwable) -> {
                    if (throwable == null) {
                        successConnect(result);
                    } else {
                        Log.e(TAG, "downloadSomethingImportant error " + throwable);
                    }
                });
    }

    private void successConnect(Boolean result) {
       getView().successConnect();
    }

    private void cancelDownloadSomethingImportant() {
        if (mDownloadSomethingImportantDisposable != null && !mDownloadSomethingImportantDisposable.isDisposed()) {
            mDownloadSomethingImportantDisposable.dispose();
        }
    }
}
