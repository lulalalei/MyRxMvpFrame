package com.demo.myrxmvpframe.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.demo.myrxmvpframe.R;
import com.demo.myrxmvpframe.activities.BuffActivity;
import com.demo.myrxmvpframe.bases.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/27.
 */

public class MallFragment extends BaseFragment implements View.OnClickListener{

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
        return R.layout.fragment_mall;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tv_test:
                startActivity(BuffActivity.class);
                break;
            default:
                break;
        }
    }
}
