package com.demo.myrxmvpframe.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.demo.myrxmvpframe.R;
import com.demo.myrxmvpframe.bases.BaseFragment;
import com.demo.myrxmvpframe.m.HomeModel;
import com.demo.myrxmvpframe.p.HomePresenter;
import com.demo.myrxmvpframe.utils.SPUtils;
import com.demo.myrxmvpframe.v.HomeContract;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/27.
 */

public class HomeFragment extends BaseFragment<HomePresenter,HomeModel> implements HomeContract.View,View.OnClickListener{

    @BindView(R.id.tv_test)
    TextView tv_test;

    @Override
    protected void initdata(Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        tv_test.setOnClickListener(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tv_test:
                mPresent.getHomeProduct(activity,this,(String) SPUtils.get(activity, "userId", ""));
                break;
            default:
                break;
        }
    }

}
