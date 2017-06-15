package com.sky.network;

import java.util.List;

/**
 * 项目名称：DailyMovie
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2017/6/15 17:15
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public abstract class HttpListResult<T> {

    public abstract int code();

    public abstract String msg();

    public abstract List<T> data();
}
