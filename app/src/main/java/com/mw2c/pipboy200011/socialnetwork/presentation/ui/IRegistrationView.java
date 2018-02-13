package com.mw2c.pipboy200011.socialnetwork.presentation.ui;

import retrofit2.Response;

/**
 * Created by Pavel Apanovskiy on 11.02.2018.
 */

public interface IRegistrationView extends IBaseView {
    void showEmptyFieldsError();

    void showProgress();

    void showResult(Response<String> result);
}
