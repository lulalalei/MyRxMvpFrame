package com.demo.myrxmvpframe.bases;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.demo.myrxmvpframe.m.BaseModel;
import com.demo.myrxmvpframe.p.BasePresenter;
import com.demo.myrxmvpframe.utils.InstanceUtil;
import com.demo.myrxmvpframe.utils.ToastUtils;
import com.demo.myrxmvpframe.v.BaseView;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/10/27.
 */

public abstract class BaseFragment<P extends BasePresenter,M extends BaseModel> extends RxFragment implements BaseView {

    public P mPresent;
    protected BaseActivity activity;
    public Context mContext;
    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (BaseActivity) getActivity();
        mPresent= InstanceUtil.getInstance(this,0);
        if (this instanceof BaseView && mPresent!=null)
        {
            mPresent.setVM(this,InstanceUtil.getInstance(this,1));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutId()==0)
        {
            return null;
        }
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder= ButterKnife.bind(this,view);
        initView();
        initListener();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initdata(savedInstanceState);
    }

    protected void startActivity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(activity, tarActivity);
        startActivity(intent);
    }

    protected void startActivity(Class<? extends Activity> tarActivity, Bundle bundle) {
        Intent intent = new Intent(activity, tarActivity);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void startActivity(Class<? extends Activity> tarActivity, Intent intent) {
        startActivity(intent);
    }

    protected void showToast(String msg) {
        ToastUtils.showToast(msg, Toast.LENGTH_LONG);
    }

    protected abstract void initdata(Bundle savedInstanceState);

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract int getLayoutId();

    @Override
    public void showMsg(String msg) {
        showToast(msg);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dissmissLoading() {

    }

    @Override
    public void initLoading() {

    }

    @Override
    public void updateLoading() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder!=null)
        {
            unbinder.unbind();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresent!=null)
        {
            mPresent.onDetached();
        }
    }

}
