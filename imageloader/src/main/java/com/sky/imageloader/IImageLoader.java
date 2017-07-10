package com.sky.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.widget.ImageView;

/**
 * 项目名称：DailyMovie
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2017/6/19 23:01
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public interface IImageLoader {

    /**
     * 最基本用法，只是用来简单加载图片，不做其他处理
     *
     * @param context   上下文
     * @param url       图片地址
     * @param imageView {@link ImageView}
     */
    void display(Context context, String url, ImageView imageView);

    /**
     * 带有加载回调方法
     *
     * @param context   上下文
     * @param url       图片地址
     * @param callback  加载回调 {@link IImageLoaderCallback}
     * @param imageView {@link ImageView}
     */
    void display(Context context, String url,
                 IImageLoaderCallback<Drawable> callback, ImageView imageView);

    /**
     * 加载本地资源图片
     *
     * @param context   {@link Context}
     * @param resId     资源ID
     * @param imageView {@link ImageView}
     */
    void display(Context context, @IdRes int resId, ImageView imageView);
}
