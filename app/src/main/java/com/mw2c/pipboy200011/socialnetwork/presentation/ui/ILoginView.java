package com.mw2c.pipboy200011.socialnetwork.presentation.ui;

import com.mw2c.pipboy200011.socialnetwork.data.entity.Login;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public interface ILoginView extends IBaseView {
    void showEmptyFieldsError();

    void showProgress();

    void showResult(Login result);
}
