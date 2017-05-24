package com.sky.dailymovie.http;

import android.support.v4.util.ArrayMap;

/**
 * Created by tonycheng on 2017/5/24.
 */

public class HeaderManager {

    /**
     * Android 最佳实践中指出当数据量不大，最好在千级以内时，
     * 使用 ArrayMap 性能要优于 HashMap.
     */
    private final ArrayMap<String, String> mDefaultHeaders = new ArrayMap<>();

}
