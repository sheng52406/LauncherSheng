package com.android.launcher3;

import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * User: JiangXuSheng
 * Emial:jiangxusheng@meizu.com
 * Date: 2015-09-21
 * Time: 15:52
 * Description: 调试类
 */
public class LogUtils {

    public static final String TAG = "Launcher3";
    private static String sTagPre = null;

    public static final String DEBUG = "DEBUG";
    public static final String WARN = "WARN";
    public static final String ERROR = "ERROE";
    public static final String VERBOSE = "VERBOSE";
    public static final String INFO = "INFO";
    private static boolean mDebug = true;

    /**
     * 是否设置调试模式
     */
    public static void setDebug(boolean isdebug) {
        mDebug = isdebug;
    }


    /**
     * 设置前缀TAG. Logcat的TAG标签将会以一下方式展示</br>
     * <pre>
     * pretag|class|method|line
     * </pre>
     * 使用preTag可以方便的与其他程序产生的日志进行分离
     *
     * @param preTag
     */
    public static void setPreTag(String preTag) {
        sTagPre = preTag;
    }

    /**
     * 调试级别info
     *
     * @param msg
     * @param tr
     */
    public static void i(String msg, Throwable tr) {
        if (!mDebug) {
            return;
        }
        i(getLogTag(), msg, tr);
    }

    /**
     * 调试级别info
     *
     * @param msg
     */
    public static void i(String msg) {
        if (!mDebug) {
            return;
        }
        i(getLogTag(), msg, (Throwable) null);
    }

    /**
     * 调试级别info
     *
     * @param tag
     * @param msg
     */
    public static void i(Object tag, String msg) {
        i(tag, msg, (Throwable) null);
    }

    /**
     * 调试级别info
     *
     * @param tag
     * @param msg
     * @param tr
     */
    public static void i(Object tag, String msg, Throwable tr) {
        log(INFO, tag, msg, tr);
    }

    /**
     * 调试级别info
     *
     * @param tag
     * @param format  格式化字符串
     * @param objects 参数
     */
    public static void i(Object tag, String format, Object... objects) {
        log(INFO, tag, format, objects);
    }

    /**
     * 调试级别 error
     *
     * @param str
     */
    public static void e(String str) {
        if (!mDebug) {
            return;
        }
        e(getLogTag(), str, (Throwable) null);
    }

    /**
     * 调试级别 error
     *
     * @param msg
     * @param tr
     */
    public static void e(String msg, Throwable tr) {
        if (!mDebug) {
            return;
        }
        e(getLogTag(), msg, tr);
    }

    /**
     * 调试级别 error
     *
     * @param tag
     * @param msg
     */
    public static void e(Object tag, String msg) {
        if (!mDebug) {
            return;
        }
        e(tag, msg, (Throwable) null);
    }

    /**
     * 调试级别 error
     *
     * @param tag
     * @param msg
     * @param tr
     */
    public static void e(Object tag, String msg, Throwable tr) {
        log(ERROR, tag, msg, tr);
    }

    /**
     * 调试级别 error
     *
     * @param tag
     * @param format  格式化字符串
     * @param objects 参数
     */
    public static void e(Object tag, String format, Object... objects) {
        if (!mDebug) {
            return;
        }
        log(ERROR, tag, format, objects);
    }

    /**
     * 调试级别 verbose
     *
     * @param msg
     * @param tr
     */
    public static void v(String msg, Throwable tr) {
        if (!mDebug) {
            return;
        }
        v(getLogTag(), msg, tr);
    }

    /**
     * 调试级别 verbose
     *
     * @param msg
     */
    public static void v(String msg) {
        if (!mDebug) {
            return;
        }
        v(getLogTag(), msg, (Throwable) null);
    }

    /**
     * 调试级别 verbose
     *
     * @param tag
     * @param str
     */
    public static void v(Object tag, String str) {
        v(tag, str, (Throwable) null);
    }

    /**
     * 调试级别 verbose
     *
     * @param tag
     * @param msg
     * @param tr
     */
    public static void v(Object tag, String msg, Throwable tr) {
        log(VERBOSE, tag, msg, tr);
    }

    /**
     * 调试级别 verbose
     *
     * @param tag
     * @param format  格式化字符串
     * @param objects 参数
     */
    public static void v(Object tag, String format, Object... objects) {
        log(VERBOSE, tag, format, objects);
    }

    /**
     * 调试级别 debug
     *
     * @param msg
     * @param tr
     */
    public static void d(String msg, Throwable tr) {
        if (!mDebug) {
            return;
        }
        d(getLogTag(), msg, tr);
    }

    /**
     * 调试级别 debug
     *
     * @param msg
     */
    public static void d(String msg) {
        if (!mDebug) {
            return;
        }
        d(getLogTag(), msg, (Throwable) null);
    }

    /**
     * 调试级别 debug
     *
     * @param tag
     * @param msg
     */
    public static void d(Object tag, String msg) {
        d(tag, msg, (Throwable) null);
    }

    /**
     * 调试级别 debug
     *
     * @param tag
     * @param msg
     * @param tr
     */
    public static void d(Object tag, String msg, Throwable tr) {
        log(DEBUG, tag, msg, tr);
    }

    /**
     * 调试级别 debug
     *
     * @param tag
     * @param format  格式化字符串
     * @param objects 参数
     */
    public static void d(Object tag, String format, Object... objects) {
        log(DEBUG, tag, format, objects);
    }

    /**
     * 调试级别 warning
     *
     * @param msg
     */
    public static void w(String msg) {
        if (!mDebug) {
            return;
        }
        w(getLogTag(), msg, (Throwable) null);
    }

    /**
     * 调试级别 warning
     *
     * @param msg
     * @param tr
     */
    public static void w(String msg, Throwable tr) {
        if (!mDebug) {
            return;
        }
        w(getLogTag(), msg, tr);
    }

    /**
     * 调试级别 warning
     *
     * @param tag
     * @param msg
     */
    public static void w(Object tag, String msg) {
        w(tag, msg, (Throwable) null);
    }

    /**
     * 调试级别 warning
     *
     * @param tag
     * @param msg
     * @param tr
     */
    public static void w(Object tag, String msg, Throwable tr) {
        log(WARN, tag, msg, tr);
    }

    /**
     * 调试级别 warning
     *
     * @param tag
     * @param format  格式化字符串
     * @param objects 参数
     */
    public static void w(Object tag, String format, Object... objects) {
        log(WARN, tag, format, objects);
    }

    private static void log(String type, Object obj, String msg, Throwable tr) {
        String tag = String.valueOf(obj);
        if (!mDebug) {
            return;
        }

        if (WARN.equals(type)) {
            Log.w(tag, msg, tr);
        } else if (ERROR.equals(type)) {
            Log.e(tag, msg, tr);
        } else if (DEBUG.equals(type)) {
            Log.d(tag, msg, tr);
        } else if (INFO.equals(type)) {
            Log.i(tag, msg, tr);
        } else if (VERBOSE.equals(type)) {
            Log.v(tag, msg, tr);
        }
    }

    /**
     * 获取类名与方法名
     */
    private static String getLogTag() {
        String tag = TAG;
        try {
            StackTraceElement stes[] = Thread.currentThread().getStackTrace();
            StackTraceElement ste = stes[4];
            String fileName = ste.getFileName();
            tag += "|" + (TextUtils.isEmpty(sTagPre) ? "" : sTagPre + "|")
                    + fileName.substring(0, fileName.lastIndexOf(".")) + "|" + ste.getMethodName()
                    + "|" + ste.getLineNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tag;
    }

    private static void log(String type, Object obj, String format, Object... objects) {
        String tag = String.valueOf(obj);
        String msg = null;
        try {
            msg = String.format(format, objects);
        } catch (Exception e) {
            msg = String.valueOf(objects);
        }

        if (!mDebug) {
            return;
        }

        if (WARN.equals(type)) {
            Log.w(tag, msg);
        } else if (ERROR.equals(type)) {
            Log.e(tag, msg);
        } else if (DEBUG.equals(type)) {
            Log.d(tag, msg);
        } else if (INFO.equals(type)) {
            Log.i(tag, msg);
        } else if (VERBOSE.equals(type)) {
            Log.v(tag, msg);
        }
    }

    public static String getLogStyle(String type, Object tag, String msg, Throwable tr) {
        StringBuilder log = new StringBuilder();
        String date = DateFormat.format("yyyy-MM-dd aa hh:mm:ss", System.currentTimeMillis())
                .toString();
        log.append("[");
        log.append(date);
        log.append("]");
        log.append("[");
        log.append(type);
        log.append("]");
        log.append("[");
        log.append(tag);
        log.append("]");
        log.append(msg);
        if (tr != null) {
            log.append(" ");
            log.append(getStackTraceString(tr));
        }
        return log.toString();
    }

    public static String getStackTraceString(Throwable tr) {
        if (tr == null) {
            return "";
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);
        return sw.toString();
    }

    /**
     * 将byte转为16进制
     *
     * @param b
     * @return
     */
    public static final String toHex(byte b) {
        return ("" + "0123456789ABCDEF".charAt(0xf & b >> 4) + "0123456789ABCDEF".charAt(b & 0xf));
    }

}
