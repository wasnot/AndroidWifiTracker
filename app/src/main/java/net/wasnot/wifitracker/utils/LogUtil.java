package net.wasnot.wifitracker.utils;

import net.wasnot.wifitracker.BuildConfig;

import android.util.Log;

/**
 * Created by akihiroaida on 2014/07/16.
 */
public class LogUtil {

    public static void d(String tag, String msg) {
        if (!BuildConfig.DEBUG) {
            return;
        }
        Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (!BuildConfig.DEBUG) {
            return;
        }
        Log.e(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (!BuildConfig.DEBUG) {
            return;
        }
        Log.i(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (!BuildConfig.DEBUG) {
            return;
        }
        Log.v(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (!BuildConfig.DEBUG) {
            return;
        }
        Log.w(tag, msg);
    }
}
