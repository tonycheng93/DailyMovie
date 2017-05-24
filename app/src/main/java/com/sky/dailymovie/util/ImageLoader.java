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
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 对 Glide 进行一层包装，这样做的好处在于后面更换其它图片加载框架时，
 * 只需要更改此处即可，不用去具体使用的地方一处处更改。
 *
 * 阿里巴巴 Java 开发手册 （四）OOP 规约 第一条提出：
 * 1. 【强制】避免通过一个类的对象引用访问此类的静态变量或静态方法，无谓增加编译器解析成
 * 本，直接用类名来访问即可。
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
                .thumbnail(0.1f)
                .into(imageView);
    }


}
