package com.mw2c.pipboy200011.socialnetwork.presentation.presenter;

import com.mw2c.pipboy200011.socialnetwork.presentation.ui.view.IBaseView;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public interface IBasePresenter<V extends IBaseView> {

    /**
     * Привязываем вьюху
     *
     * @param view - вьюха
     */
    void bindView(V view);

    /**
     * Отвязываемся от вьюхи
     */
    void unbindView();

    /**
     * Получаем view
     *
     * @return
     */
    V getView();

    /**
     * Обнуляем ссылки в презентере
     */
    void destroyPresenter();
}
