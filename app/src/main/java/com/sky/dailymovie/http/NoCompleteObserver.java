package com.sky.dailymovie.http;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by tonycheng on 2017/7/31.
 */

/**
 * 通常情况下，我们不需要对 {@link Observer} onComplete 方法进行处理，
 * 可以使用这个类
 */

public abstract class NoCompleteObserver<T> implements Observer<T> {
    @Override
    public void onComplete() {

    }
}
