package com.sky.dailymovie.data.remote;

import com.sky.dailymovie.data.model.Category;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 项目名称：DailyMovie
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2017/5/23 23:52
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public interface DailyMovieService {

    /**
     * 获取视频分类
     */
    @GET("v2/categories")
    Observable<List<Category>> getCategorise();
}
