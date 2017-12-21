package com.demo.myrxmvpframe.net;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import com.demo.myrxmvpframe.R;
import com.demo.myrxmvpframe.beans.ApiResult;
import com.demo.myrxmvpframe.constants.CommonConstants;
import com.demo.myrxmvpframe.utils.CommonDialogUtils;
import com.demo.myrxmvpframe.utils.LogUtils;
import com.demo.myrxmvpframe.utils.ToastUtils;
import com.demo.myrxmvpframe.v.BaseView;
import com.google.gson.JsonParseException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.demo.myrxmvpframe.net.DefaultObserver.ExceptionReason.CONNECT_ERROR;
import static com.demo.myrxmvpframe.net.DefaultObserver.ExceptionReason.CONNECT_TIMEOUT;
import static com.demo.myrxmvpframe.net.DefaultObserver.ExceptionReason.PARSE_ERROR;
import static com.demo.myrxmvpframe.net.DefaultObserver.ExceptionReason.UNKNOWN_ERROR;


/**
 * Created by zhpan on 2017/4/18.
 */

public abstract class DefaultObserver<V extends BaseView,T extends ApiResult> implements Observer<T> {

    private Activity activity;
    //  Activity 是否在执行onStop()时取消订阅
    private boolean isAddInStop = false;
    private CommonDialogUtils dialogUtils;

    private V view;

    public DefaultObserver(Activity activity) {
        this.activity = activity;
        dialogUtils=new CommonDialogUtils();
        dialogUtils.showProgress(activity);
    }

    public DefaultObserver(Activity activity,V view) {
        this.activity = activity;
        this.view=view;
        dialogUtils=new CommonDialogUtils();
        dialogUtils.showProgress(activity);
    }

    public DefaultObserver(Activity activity, boolean isShowLoading) {
        this.activity = activity;
        dialogUtils=new CommonDialogUtils();
        if (isShowLoading) {
            dialogUtils.showProgress(activity,"Loading...");
        }
    }

    public DefaultObserver(Activity activity, boolean isShowLoading,V view) {
        this.activity = activity;
        this.view=view;
        dialogUtils=new CommonDialogUtils();
        if (isShowLoading) {
            dialogUtils.showProgress(activity,"Loading...");
        }
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T response) {
        dismissProgress();
        if (CommonConstants.REQUEST_SUCCESS.equalsIgnoreCase(response.getRespCode())) {
            onSuccess(response);
        } else {
            onFail(response);
        }
        /*if (response.getCode() == 200) {
            onSuccess(response);
        } else {
            onFail(response);
        }*/
    }

    private void dismissProgress(){
        if(dialogUtils!=null){
            dialogUtils.dismissProgress();
        }
    }

    @Override
    public void onError(Throwable e) {
        LogUtils.e("Retrofit", e.getMessage());
        dismissProgress();
        if (e instanceof HttpException) {     //   HTTP错误
            onException(ExceptionReason.BAD_NETWORK);
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {   //   连接错误
            onException(CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {   //  连接超时
            onException(CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {   //  解析错误
            onException(PARSE_ERROR);
        } else {
            onException(UNKNOWN_ERROR);
        }
    }

    @Override
    public void onComplete() {
        //dismissProgress();
        Log.e("======method======","==========");
    }

    /**
     * 请求成功
     *
     * @param response 服务器返回的数据
     */
    abstract public void onSuccess(T response);

    /**
     * 服务器返回数据，但响应码不为200
     *
     * @param response 服务器返回的数据
     */
    public void onFail(T response) {
        String message = response.getRespMsg();
        if (CommonConstants.REQUEST_OUTOFDATE.equalsIgnoreCase(response.getRespCode())) {
            //session过期，需要重新登录
            ToastUtils.showToast(response.getRespMsg());
            /*Intent intent = new Intent(MyApplication.getContext(), LoginStepOneActivity.class);
            intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
            MyApplication.getContext().startActivity(intent);*/
        }else
        {
            if (TextUtils.isEmpty(message)) {
                ToastUtils.showToast(R.string.response_return_error);
            } else {
                ToastUtils.showToast(message);
            }
        }
    }

    /**
     * 请求异常
     *
     * @param reason
     */
    public void onException(ExceptionReason reason) {
        switch (reason) {
            case CONNECT_ERROR:
                ToastUtils.showToast(R.string.connect_error);
                break;

            case CONNECT_TIMEOUT:
                ToastUtils.showToast(R.string.connect_timeout);
                break;

            case BAD_NETWORK:
                ToastUtils.showToast(R.string.bad_network);
                break;

            case PARSE_ERROR:
                ToastUtils.showToast(R.string.parse_error);
                break;

            case UNKNOWN_ERROR:
            default:
                ToastUtils.showToast(R.string.unknown_error);
                break;
        }
    }

    /**
     * 请求网络失败原因
     */
    public enum ExceptionReason {
        /**
         * 解析数据失败
         */
        PARSE_ERROR,
        /**
         * 网络问题
         */
        BAD_NETWORK,
        /**
         * 连接错误
         */
        CONNECT_ERROR,
        /**
         * 连接超时
         */
        CONNECT_TIMEOUT,
        /**
         * 未知错误
         */
        UNKNOWN_ERROR,
    }
}
