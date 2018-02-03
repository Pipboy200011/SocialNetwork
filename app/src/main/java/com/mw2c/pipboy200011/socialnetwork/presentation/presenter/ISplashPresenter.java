package com.mw2c.pipboy200011.socialnetwork.presentation.presenter;

import com.mw2c.pipboy200011.socialnetwork.presentation.ui.ISplashView;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public interface ISplashPresenter {

    void downloadSomethingImportant();

    void destroyPresenter();

    /**
     * Привязываем вьюху
     *
     * @param view - вьюха
     */
    void bindView(ISplashView view);

    /**
     * Отвязываемся от вьюхи
     */
    void unbindView();
}
