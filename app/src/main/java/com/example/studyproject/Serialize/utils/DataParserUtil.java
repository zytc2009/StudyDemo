//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.studyproject.Serialize.utils;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import java.lang.reflect.Type;
import java.util.List;

public class DataParserUtil {
    public DataParserUtil() {
    }

    public static <T> T parseObject(String result, Class<T> valueType) {
        try {
            return JSON.parseObject(result, valueType);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static <T> T parseObject(JSONObject result, Class<T> valueType) {
        try {
            return result.toJavaObject(valueType);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static <T> T parseObject(JSONArray result, Class<T> valueType) {
        try {
            return JSON.parseObject(result.toJSONString(), valueType);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static JSONObject parseAsJSONObject(String result) {
        try {
            return JSON.parseObject(result);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> parseArray(String result, Class<T> valueType) {
        try {
            return JSONArray.parseArray(result, valueType);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> parseArrayList(JSONArray result, Class<T> valueType) {
        try {
            return parseArray(result.toJSONString(), valueType);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static <T> T parseObject(String result, TypeReference<T> type) {
        try {
            return JSON.parseObject(result, type, new Feature[0]);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static <T> T parseObject(String result, Type type) {
        try {
            return JSON.parseObject(result, type, new Feature[0]);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static String parseToJson(Object obj) {
        try {
            return JSON.toJSONString(obj);
        } catch (Throwable var2) {
            var2.printStackTrace();
            return "";
        }
    }

    public static int getJsonInt(JSONObject result, String key) {
        if (null == result) {
            return 0;
        } else {
            return !result.containsKey(key) ? 0 : result.getIntValue(key);
        }
    }

    public static long getJsonLong(JSONObject result, String key) {
        if (null == result) {
            return 0L;
        } else {
            return !result.containsKey(key) ? 0L : result.getLong(key);
        }
    }

    public static String getJsonStr(JSONObject result, String key) {
        if (null == result) {
            return null;
        } else {
            return !result.containsKey(key) ? null : result.getString(key);
        }
    }

    public static String getJsonStr(JSONObject result, String key, String defValue) {
        if (null == result) {
            return defValue;
        } else {
            return !result.containsKey(key) ? defValue : result.getString(key);
        }
    }

    public static boolean getJsonBoolean(JSONObject result, String key, boolean defaultValue) {
        if (null == result) {
            return defaultValue;
        } else {
            return !result.containsKey(key) ? defaultValue : result.getBoolean(key);
        }
    }

    public static JSONObject getJsonObj(JSONObject result, String key) {
        if (null == result) {
            return null;
        } else {
            return !result.containsKey(key) ? null : result.getJSONObject(key);
        }
    }

    public static JSONArray getJsonArr(JSONObject result, String key) {
        if (null == result) {
            return null;
        } else {
            return !result.containsKey(key) ? null : result.getJSONArray(key);
        }
    }

    public static String objectToString(Object object) {
        return JSON.toJSONString(object);
    }

    public static boolean isSpecialErrorCode(int errorCode) {
        return errorCode == 15000 || errorCode == 1204 || errorCode == 1205 || errorCode == 1034;
    }

    public static Object parseBody(JSONObject jo, Type valueType) {
        String body = getJsonStr(jo, "body");
        if (valueType.equals(Object.class)) {
            return getJsonStr(jo, "message");
        } else if (valueType.equals(String.class)) {
            return body;
        } else if (valueType.equals(JSONObject.class)) {
            return getJsonObj(jo, "body");
        } else {
            return TextUtils.isEmpty(body) ? null : JSON.parseObject(body, valueType, new Feature[0]);
        }
    }

    public interface OnParseListener {
        Object onParseBody(JSONObject var1);
    }
}
