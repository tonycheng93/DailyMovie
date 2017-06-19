package com.sky.dailymovie.imageloader;

/**
 * 项目名称：DailyMovie
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2017/6/19 23:14
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class ImageLoaderFactory {

    public static IImageLoaderManager getImageLoaderManager() {
        return GlideImageLoaderManager.getInstance();
    }
}
