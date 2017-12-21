package com.demo.myrxmvpframe.utils;

import android.widget.Toast;

import com.demo.myrxmvpframe.bases.MyApplication;


public class ToastUtils {

    private static Toast mToast;

    /**
     * 非阻塞试显示Toast,防止出现连续点击Toast时的显示问题
     */
    public static void showToast(CharSequence text, int duration) {
        if (MyApplication.getContext() != null) {
            if (mToast == null) {
                mToast = Toast.makeText(MyApplication.getContext(), text, duration);
            } else {
                mToast.setText(text);
                mToast.setDuration(duration);
            }
            mToast.show();
        }
    }

    public static void showToast(CharSequence text) {
        showToast(text, Toast.LENGTH_SHORT);
    }

    public static void showToast(int textId) {
        showToast(MyApplication.getContext().getResources().getText(textId), Toast.LENGTH_SHORT);
    }

}
