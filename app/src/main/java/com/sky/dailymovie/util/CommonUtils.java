package com.sky.dailymovie.util;

import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by tonycheng on 2017/6/30.
 */

public final class CommonUtils {

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    /**
     * 获取指定进程号对应的进程名
     *
     * @param pid 进程号 （当前进程号 android.os.Process.myPid()）
     * @return 进程名
     */
    public static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
