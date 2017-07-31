package com.sky.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * 项目名称：DailyMovie
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2017/6/19 23:12
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class GlideImageLoader implements IImageLoader {

    private GlideImageLoader() {
    }

    private static class SingletonHolder {
        private static final GlideImageLoader INSTANCE = new GlideImageLoader();
    }

    public static GlideImageLoader getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static final RequestOptions OPTIONS = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop();

    @Override
    public void display(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .thumbnail(0.1f)
                .apply(OPTIONS)
                .into(imageView);
    }

    @Override
    public void display(Context context, String url, IImageLoaderCallback<Drawable> callback, ImageView imageView) {

    }

    @Override
    public void display(Context context, @DrawableRes int resId, ImageView imageView) {

    }
}
