package com.geniusvjr.jpasswordassistant.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by dream on 16/5/28.
 */
public class SPUtils {
    /**
     * 保存在手机的文件名
     */
    public static final String FILE_NAME = "PA-SP";

    public static Object get(Context context,String key,Object defaultObject){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (defaultObject instanceof String)
        {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer)
        {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean)
        {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float)
        {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long)
        {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }
}
