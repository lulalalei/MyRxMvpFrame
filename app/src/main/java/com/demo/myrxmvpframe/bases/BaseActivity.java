package com.demo.myrxmvpframe.bases;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.demo.myrxmvpframe.m.BaseModel;
import com.demo.myrxmvpframe.p.BasePresenter;
import com.demo.myrxmvpframe.utils.AppManager;
import com.demo.myrxmvpframe.utils.InstanceUtil;
import com.demo.myrxmvpframe.utils.ToastUtils;
import com.demo.myrxmvpframe.v.BaseView;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/10/25.
 */

public abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends RxAppCompatActivity implements BaseView {

    public P mPresenter;
    public Context mContext;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
        setContentView(getLayoutId());
        unbinder= ButterKnife.bind(this);
        mContext=this;
        mPresenter= InstanceUtil.getInstance(this,0);
        initView();
        if (this instanceof BaseView &&mPresenter!=null)
        {
            mPresenter.setVM(this,InstanceUtil.getInstance(this,1));
        }
        initData();
    }

    public void showToast(String msg) {
        ToastUtils.showToast(msg, Toast.LENGTH_LONG);
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null)
        {
            mPresenter.onDetached();
        }
        if (unbinder!=null)
        {
            unbinder.unbind();
        }
        AppManager.getInstance().finishActivity();
    }

    @Override
    public void showMsg(String msg) {
        showToast(msg);
    }

    @Override
    public void initLoading() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dissmissLoading() {

    }

    @Override
    public void updateLoading() {

    }
}
