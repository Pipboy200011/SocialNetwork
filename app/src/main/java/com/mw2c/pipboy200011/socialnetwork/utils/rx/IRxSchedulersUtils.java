package com.mw2c.pipboy200011.socialnetwork.utils.rx;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;

/**
 * Created by Pavel Apanovskiy on 25.11.2017.
 */

public interface IRxSchedulersUtils {

    Scheduler getMainThreadScheduler();

    Scheduler getIOScheduler();

    <T> ObservableTransformer<T, T> getIOToMainTransformer();
}
