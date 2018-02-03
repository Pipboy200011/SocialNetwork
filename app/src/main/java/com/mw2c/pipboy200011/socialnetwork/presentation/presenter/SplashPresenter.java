package com.mw2c.pipboy200011.socialnetwork.presentation.presenter;

import android.util.Log;

import com.mw2c.pipboy200011.socialnetwork.domain.SplashInteractor;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.ISplashView;
import com.mw2c.pipboy200011.socialnetwork.utils.rx.IRxSchedulersUtils;

import io.reactivex.disposables.Disposable;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public class SplashPresenter implements ISplashPresenter {

    private static final String TAG = "SplashPresenter";

    private final SplashInteractor mSplashInteractor;
    private final IRxSchedulersUtils mRxSchedulersUtils;

    private Disposable mDownloadSomethingImportantDisposable;
    private ISplashView mView;

    public SplashPresenter(SplashInteractor interactor,
                           IRxSchedulersUtils rxSchedulersUtils) {
        mSplashInteractor = interactor;
        mRxSchedulersUtils = rxSchedulersUtils;
    }

    @Override
    public void bindView(ISplashView view) {
        mView = view;
    }

    @Override
    public void unbindView() {
        mView = null;
    }

    @Override
    public void destroyPresenter() {
        cancelDownloadSomethingImportant();
    }

    @Override
    public void downloadSomethingImportant() {
        mDownloadSomethingImportantDisposable = mSplashInteractor.downloadSomethingImportant()
                .subscribeOn(mRxSchedulersUtils.getIOScheduler())
                .observeOn(mRxSchedulersUtils.getMainThreadScheduler())
                .subscribe((result, throwable) -> {
                    if (throwable == null) {
                        doSomethingElse(result);
                    } else {
                        Log.e(TAG, "downloadSomethingImportant error " + throwable);
                    }
                });
    }

    private void doSomethingElse(Boolean result) {
        mView.updateResult(result);
    }

    private void cancelDownloadSomethingImportant() {
        if (mDownloadSomethingImportantDisposable != null && !mDownloadSomethingImportantDisposable.isDisposed()) {
            mDownloadSomethingImportantDisposable.dispose();
        }

    }
}
