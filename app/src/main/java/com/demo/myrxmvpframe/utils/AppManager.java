package com.demo.myrxmvpframe.utils;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * Created by Administrator on 2017/7/25.
 */

public class AppManager {

    private static Stack<Activity>
            activityStack;

    private static AppManager instance;

    private static final String DEFAULT_DATA_BASEPATH = "/huibx"; // 缓存目录
    public String DEFAULT_DATA_IMAGEPATH = DEFAULT_DATA_BASEPATH + "/IMAGE"; // 小图缓存地址
    public String DEFAULT_DATA_TEMP = DEFAULT_DATA_BASEPATH + "/TEMP"; // 备份数据地址
    public String DEFAULT_DATA_BIG_IMAGEPATH = DEFAULT_DATA_BASEPATH + "/BIGIMAGE"; // 大图缓存地址

    private AppManager() {
        String rootPath = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        DEFAULT_DATA_IMAGEPATH = rootPath + DEFAULT_DATA_IMAGEPATH;
        DEFAULT_DATA_TEMP = rootPath + DEFAULT_DATA_TEMP;
        DEFAULT_DATA_BIG_IMAGEPATH = rootPath + DEFAULT_DATA_BIG_IMAGEPATH;
    }

    /**
     * 单一实例
     */

    public static AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = null;
        if (activityStack.size() > 0) {
            activity = activityStack.lastElement();
        }
        return activity;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);

    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = currentActivity();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            //activity.finish();
            activityStack.remove(activity);
            activity = null;
        }
    }
    /**
     * 结束指定的Activity
     */
    public void finishParticularActivity(Class<?> tClass) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(tClass)) {
                if (activity != null) {
                    activityStack.remove(activity);
                    activity.finish();
                }
            }
        }


    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    public boolean processBackKey(Class<? extends Activity>... classes) {
        for (Class<? extends Activity> clazz : classes) {
            if (currentActivity().getClass().getSimpleName().equals(clazz.getSimpleName())) {
                //进入最底层的页面 需要做具体操作来结束app页面，入弹出dialog
                // TODO: 2016/11/25
                return true;
            }
        }
        return false;
    }

    public void AppExit(Context context) {
        finishAllActivity();
//        ActivityManager activityManager=context.getSystemService(Context.ACTIVITY_SERVICE);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

}
