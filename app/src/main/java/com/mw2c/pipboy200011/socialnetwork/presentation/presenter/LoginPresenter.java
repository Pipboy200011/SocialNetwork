package com.mw2c.pipboy200011.socialnetwork.presentation.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.mw2c.pipboy200011.socialnetwork.Screens;
import com.mw2c.pipboy200011.socialnetwork.data.entity.Login;
import com.mw2c.pipboy200011.socialnetwork.domain.LoginInteractor;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.ILoginView;
import com.mw2c.pipboy200011.socialnetwork.utils.rx.IRxSchedulersUtils;

import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public class LoginPresenter extends BasePresenter<ILoginView> {

    private static final String TAG = "LoginPresenter";

    private final LoginInteractor mLoginInteractor;
    private final IRxSchedulersUtils mRxSchedulersUtils;
    private final Router mRouter;

    private Disposable mEnterButtonClickDisposable;

    public LoginPresenter(LoginInteractor interactor,
                          IRxSchedulersUtils rxSchedulersUtils,
                          Router router) {
        mLoginInteractor = interactor;
        mRxSchedulersUtils = rxSchedulersUtils;
        mRouter = router;
    }

    @Override
    public void destroyPresenter() {
        cancelTryToLogin();
    }

    public void enterButtonClick(String mail, String password) {
        if (!TextUtils.isEmpty(mail) && !TextUtils.isEmpty(password)) {
            getView().showProgress();
            mEnterButtonClickDisposable = mLoginInteractor.tryToLogin(mail, password)
                    .subscribeOn(mRxSchedulersUtils.getIOScheduler())
                    .observeOn(mRxSchedulersUtils.getMainThreadScheduler())
                    .subscribe((result, throwable) -> {
                        if (throwable == null) {
                            loginSuccess(result);
                        } else {
                            Log.e(TAG, "tryToLogin error " + throwable);
                        }
                    });
        } else {
            getView().showEmptyFieldsError();
        }
    }

    public void registerButtonClick() {
        mRouter.navigateTo(Screens.REGISTRATION_SCREEN);
    }

    private void loginSuccess(Login result) {
        getView().showResult(result);
    }

    private void cancelTryToLogin() {
        if (mEnterButtonClickDisposable != null && !mEnterButtonClickDisposable.isDisposed()) {
            mEnterButtonClickDisposable.dispose();
        }

    }
}
