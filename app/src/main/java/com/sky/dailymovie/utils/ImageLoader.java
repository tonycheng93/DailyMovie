package com.sky.dailymovie.utils;

/**
 * 项目名称：DailyMovie
 * 类描述：图片加载包装工具类
 * 创建人：tonycheng
 * 创建时间：2017/5/22 23:35
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 对 Glide 进行一层包装，这样做的好处在于后面更换其它图片加载框架时，
 * 只需要更改此处即可，不用去具体使用的地方一处处更改。
 */
public class ImageLoader {
    /**
     * @param context   上下文
     * @param url       图片地址
     * @param imageView ImageView
     */
    public static void display(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }
}
