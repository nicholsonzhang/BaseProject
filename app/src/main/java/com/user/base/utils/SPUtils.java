package com.user.base.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.user.base.MyApplication;

/**
 * SharedPreference 工具类
 */

public class SPUtils {
    private static final String FILE_NAME = "app_info";
    private static volatile SPUtils sInstance;
    private SharedPreferences preferences;

    private SPUtils() {
        preferences = MyApplication.getApplication().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

    }

    public static SPUtils getInstance() {
        if (sInstance == null) {
            synchronized (SPUtils.class) {
                if (sInstance == null) {
                    sInstance = new SPUtils();
                }
            }
        }
        return sInstance;
    }

    public void putInt(String key, int value) {
        preferences.edit().putInt(key, value).apply();
    }

    public int getInt(String key, Integer... defValue) {
        if (defValue.length > 0){
            return preferences.getInt(key,defValue[0]);
        }
        return preferences.getInt(key, 0);
    }

    public void putFloat(String key, float value) {
        preferences.edit().putFloat(key, value).apply();

    }

    public float getFloat(String key, Float... defFloat) {
        if (defFloat.length >0){
            return preferences.getFloat(key,defFloat[0]);
        }
        return preferences.getFloat(key, 0);
    }

    public void putBoolean(String key, boolean value) {

        preferences.edit().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key,Boolean... defValue) {
        if (defValue.length>0){
            return preferences.getBoolean(key,defValue[0]);
        }
        return preferences.getBoolean(key, false);
    }

    public void putString(String key, String value) {
        preferences.edit().putString(key, value).apply();
    }

    public String getString(String key, String... defValue) {
        if (defValue.length > 0) {
            return preferences.getString(key, defValue[0]);
        }
        return preferences.getString(key, "");

    }
}
