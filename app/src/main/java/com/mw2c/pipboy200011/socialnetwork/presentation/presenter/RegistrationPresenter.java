package com.mw2c.pipboy200011.socialnetwork.presentation.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.mw2c.pipboy200011.socialnetwork.Screens;
import com.mw2c.pipboy200011.socialnetwork.domain.RegistrationInteractor;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.IRegistrationView;
import com.mw2c.pipboy200011.socialnetwork.utils.rx.IRxSchedulersUtils;

import io.reactivex.disposables.Disposable;
import retrofit2.Response;
import ru.terrakok.cicerone.Router;

/**
 * Created by Pavel Apanovskiy on 11.02.2018.
 */

public class RegistrationPresenter extends BasePresenter<IRegistrationView> {

    private static final String TAG = "RegistrationPresenter";

    private final RegistrationInteractor mRegistrationInteractor;
    private final IRxSchedulersUtils mRxSchedulersUtils;
    private final Router mRouter;
    private Disposable mRegistrationDisposable;

    public RegistrationPresenter(RegistrationInteractor interactor,
                                 IRxSchedulersUtils rxSchedulersUtils,
                                 Router router) {
        mRegistrationInteractor = interactor;
        mRxSchedulersUtils = rxSchedulersUtils;
        mRouter = router;
    }

    @Override
    public void destroyPresenter() {
        cancelRegistration();
    }


    public void registrationButtonClick(String name,
                                        String surname,
                                        String mail,
                                        String password) {
        if (!TextUtils.isEmpty(name) &&
                !TextUtils.isEmpty(surname) &&
                !TextUtils.isEmpty(mail) &&
                !TextUtils.isEmpty(password)) {

            getView().showProgress();
            mRegistrationDisposable = mRegistrationInteractor.register(
                    name,
                    surname,
                    mail,
                    password)
                    .subscribeOn(mRxSchedulersUtils.getIOScheduler())
                    .observeOn(mRxSchedulersUtils.getMainThreadScheduler())
                    .subscribe((result, throwable) -> {
                        if (throwable == null) {
                            registrationSuccess(result);
                        } else {
                            Log.e(TAG, "registration error " + throwable);
                        }
                        mRouter.newRootScreen(Screens.LOGIN_SCREEN);
                    });
        } else {
            getView().showEmptyFieldsError();
        }

    }

    private void registrationSuccess(Response<String> result) {
        getView().showResult(result);
    }

    private void cancelRegistration() {
        if (mRegistrationDisposable != null && !mRegistrationDisposable.isDisposed()) {
            mRegistrationDisposable.dispose();
        }

    }
}
