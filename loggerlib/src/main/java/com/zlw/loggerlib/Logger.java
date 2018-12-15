package com.zlw.loggerlib;

import android.util.Log;

import java.util.Locale;

/**
 * @author zlw on 2018/12/15.
 *         TODO:cache long log
 */
public class Logger {

    public static boolean isShow = true;

    private static final String TAG = Logger.class.getSimpleName();
    private static final String PRE = "###";
    private static final String SPACE = "====================================================================================================";

    public static void v(String tag, String format, Object... args) {
        String message = buildMessage(format, args);
        tag = formatLength(PRE + tag, 28);
        Log.v(tag, message);
    }

    public static void v(Throwable throwable, String tag, String format, Object... args) {
        String message = buildMessage(format, args);
        tag = formatLength(PRE + tag, 28);

        Log.v(tag, message, throwable);
    }

    public static void d(String tag, String format, Object... args) {
        String message = buildMessage(format, args);
        tag = formatLength(PRE + tag, 28);

        Log.d(tag, message);
    }

    public static void d(Throwable throwable, String tag, String format, Object... args) {
        String message = buildMessage(format, args);
        tag = formatLength(PRE + tag, 28);

        Log.d(tag, message, throwable);
    }

    public static void i(String tag, String format, Object... args) {
        String message = buildMessage(format, args);
        tag = formatLength(PRE + tag, 28);

        Log.i(tag, message);
    }

    public static void i(Throwable throwable, String tag, String format, Object... args) {
        String message = buildMessage(format, args);
        tag = formatLength(PRE + tag, 28);

        Log.i(tag, message, throwable);
    }

    public static void w(String tag, String format, Object... args) {
        String message = buildMessage(format, args);
        tag = formatLength(PRE + tag, 28);

        Log.w(tag, message);
    }

    public static void w(Throwable throwable, String tag, String format, Object... args) {
        String message = buildMessage(format, args);
        tag = formatLength(PRE + tag, 28);

        Log.w(tag, message, throwable);
    }

    public static void e(String tag, String format, Object... args) {
        String message = buildMessage(format, args);
        tag = formatLength(PRE + tag, 28);

        Log.e(tag, message);
    }

    public static void e(Throwable throwable, String tag, String format, Object... args) {
        String message = buildMessage(format, args);
        tag = formatLength(PRE + tag, 28);
        Log.e(tag, message, throwable);
    }

    private static String buildMessage(String format, Object[] args) {
        try {
            String msg = (args == null || args.length == 0) ? format : String.format(Locale.getDefault(), format, args);
            if (!isShow) {
                return msg;
            }
            StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();
            String caller = "";
            String callingClass = "";
            String callFile = "";
            int lineNumber = 0;
            for (int i = 2; i < trace.length; i++) {
                Class<?> clazz = trace[i].getClass();
                if (!clazz.equals(Logger.class)) {
                    callingClass = trace[i].getClassName();
                    callingClass = callingClass.substring(callingClass
                            .lastIndexOf('.') + 1);
                    caller = trace[i].getMethodName();
                    callFile = trace[i].getFileName();
                    lineNumber = trace[i].getLineNumber();
                    break;
                }
            }

            String method = String.format(Locale.getDefault(), "[%03d] %s.%s(%s:%d)"
                    , Thread.currentThread().getId(), callingClass, caller, callFile, lineNumber);

            return String.format(Locale.getDefault(), "%s> %s", formatLength(method, 93), msg);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return "----->ERROR LOG STRING<------";
    }

    private static String formatLength(String src, int len) {
        StringBuilder sb = new StringBuilder();
        if (src.length() >= len) {
            sb.append(src);
        } else {
            sb.append(src);
            sb.append(SPACE.substring(0, len - src.length()));
        }
        return sb.toString();
    }

}
