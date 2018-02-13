package com.mw2c.pipboy200011.socialnetwork.presentation.ui;

/**
 * Created by Pavel Apanovskiy on 11.02.2018.
 */

public interface IRegistrationView extends IBaseView {
    void showEmptyFieldsError();

    void showProgress();

    void showResult(String result);
}
