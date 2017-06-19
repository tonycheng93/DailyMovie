package com.sky.dailymovie.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

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

public class GlideImageLoaderManager implements IImageLoaderManager {

    private GlideImageLoaderManager() {
    }

    private static class Holder {
        private static GlideImageLoaderManager sInstance = new GlideImageLoaderManager();
    }

    public static GlideImageLoaderManager getInstance() {
        return Holder.sInstance;
    }

    private static final RequestOptions mOptions = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop();

    @Override
    public void display(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .thumbnail(0.1f)
                .apply(mOptions)
                .into(imageView);
    }

    @Override
    public void display(Context context, String url, final IImageLoaderCallback<Drawable> callback,
                        ImageView imageView) {
        Glide.with(context)
                .load(url)
                .thumbnail(0.1f)
                .apply(mOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<Drawable> target, boolean isFirstResource) {
                        return callback.onFail(e);
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model,
                                                   Target<Drawable> target, DataSource
                                                           dataSource, boolean isFirstResource) {
                        return callback.onReady(resource);
                    }
                })
                .into(imageView);
    }
}
