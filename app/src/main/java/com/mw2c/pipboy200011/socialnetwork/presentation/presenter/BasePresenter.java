package com.mw2c.pipboy200011.socialnetwork.presentation.presenter;

import com.mw2c.pipboy200011.socialnetwork.presentation.ui.view.IBaseView;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {

    private T mView;

    @Override
    public void bindView(T view) {
        mView = view;
    }

    @Override
    public void unbindView() {
        mView = null;
    }

    @Override
    public T getView() {
        return mView;
    }

    @Override
    public void destroyPresenter() {
    }
}
