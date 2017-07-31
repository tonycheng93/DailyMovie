package com.sky.dailymovie.ui.category.presenter;

import com.sky.dailymovie.data.DataManager;
import com.sky.dailymovie.data.model.Category;
import com.sky.dailymovie.http.NoCompleteObserver;
import com.sky.dailymovie.ui.base.BasePresenter;
import com.sky.dailymovie.ui.category.view.ICategoryView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by tonycheng on 2017/7/31.
 */

public class CategoryPresenter extends BasePresenter<ICategoryView> {

    private final DataManager mDataManager;
    private Disposable mDisposable = null;

    @Inject
    public CategoryPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(ICategoryView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    public void loadCategories() {
        checkViewAttached();
        mDataManager.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NoCompleteObserver<List<Category>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull List<Category> categories) {
                        if (categories.isEmpty()) {
                            getMvpView().showCategoriesEmpty();
                        } else {
                            getMvpView().showCategories(categories);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Timber.e(e, "there was an error loading categories.");
                        getMvpView().showError();
                    }
                });
    }
}
