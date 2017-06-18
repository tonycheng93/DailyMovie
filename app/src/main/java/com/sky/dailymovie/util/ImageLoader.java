package com.sky.dailymovie.util;

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
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;

/**
 * 对 Glide 进行一层包装，这样做的好处在于后面更换其它图片加载框架时，
 * 只需要更改此处即可，不用去具体使用的地方一处处更改。
 * <p>
 * 阿里巴巴 Java 开发手册 （四）OOP 规约 第一条提出：
 * 1. 【强制】避免通过一个类的对象引用访问此类的静态变量或静态方法，无谓增加编译器解析成
 * 本，直接用类名来访问即可。
 * <p>
 * 由于我这里使用的是 Glide 4.0 和之前的版本 API 变化比较大，
 * 具体用法见 {@link Glide http://bumptech.github.io/glide/}
 */
public class ImageLoader {

    private static final RequestOptions mOptions = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop();

    /**
     * 基本用法，只是用来加载简单图片，不做其他处理
     *
     * @param context   上下文
     * @param url       图片地址
     * @param imageView {@link ImageView}
     */
    public static void display(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .thumbnail(0.1f)
                .apply(mOptions)
                .into(imageView);
    }

    /**
     * 需要加载回调
     *
     * @param context         上下文
     * @param url             图片地址
     * @param requestListener 加载回调
     * @param imageView       {@link ImageView}
     */
    public static void display(Context context, String url,
                               RequestListener<Drawable> requestListener, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .thumbnail(0.1f)
                .apply(mOptions)
                .listener(requestListener)
                .into(imageView);
    }

}
