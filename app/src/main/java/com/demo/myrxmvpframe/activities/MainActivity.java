package com.demo.myrxmvpframe.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demo.myrxmvpframe.R;
import com.demo.myrxmvpframe.bases.BaseActivity;
import com.demo.myrxmvpframe.beans.HeaderHelper;
import com.demo.myrxmvpframe.constants.CommonConstants;
import com.demo.myrxmvpframe.customviews.BottomBar;
import com.demo.myrxmvpframe.fragments.HomeFragment;
import com.demo.myrxmvpframe.fragments.MallFragment;
import com.demo.myrxmvpframe.fragments.MineFragment;
import com.demo.myrxmvpframe.m.MainModel;
import com.demo.myrxmvpframe.p.MainPresenter;
import com.demo.myrxmvpframe.utils.MD5Utils;
import com.demo.myrxmvpframe.v.MainContract;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainContract.View,View.OnClickListener{

    @BindView(R.id.et_pwd)
    EditText et_pwd;
    @BindView(R.id.tv_login)
    TextView tv_login;
    @BindView(R.id.rl_tabContent)
    RelativeLayout rl_tabContent;
    @BindView(R.id.bb_bottom)
    BottomBar bb_bottom;

    HomeFragment homeFragment;
    MallFragment mallFragment;
    MineFragment mineFragment;

    FragmentManager manager;

    int currentTap=0;

    @Override
    protected void initData() {


    }

    @Override
    protected void initView() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        homeFragment = new HomeFragment();

        transaction.add(R.id.rl_tabContent,homeFragment).commit();
        bb_bottom.changeTab(0);

        bb_bottom.setListener(new BottomBar.ChangeListener() {
            @Override
            public void changeTab2(int tab) {
                if (currentTap==tab)
                {
                    return;
                }
                FragmentTransaction transaction = manager.beginTransaction();
                hideFragments(transaction);
                switch (tab)
                {
                    case 0:
                        if (homeFragment==null)
                        {
                            homeFragment=new HomeFragment();
                            transaction.add(R.id.rl_tabContent,homeFragment);
                        }
                        else
                        {
                            transaction.show(homeFragment);
                        }
                        break;
                    case 1:
                        if (mallFragment==null)
                        {
                            mallFragment=new MallFragment();
                            transaction.add(R.id.rl_tabContent,mallFragment);
                        }
                        else
                        {
                            transaction.show(mallFragment);
                        }
                        break;
                    case 2:
                        if (mineFragment==null)
                        {
                            mineFragment=new MineFragment();
                            transaction.add(R.id.rl_tabContent,mineFragment);
                        }
                        else
                        {
                            transaction.show(mineFragment);
                        }
                        break;
                    default:
                        break;
                }
                transaction.commit();
                currentTap=tab;
            }
        });

    }

    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment!=null)
        {
            transaction.hide(homeFragment);
        }
        if (mallFragment!=null)
        {
            transaction.hide(mallFragment);
        }
        if (mineFragment!=null)
        {
            transaction.hide(mineFragment);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tv_login:
                String header = HeaderHelper.getHeaderInfo();
                mPresenter.login(this,"15735926343", MD5Utils.MD5(et_pwd.getText().toString().trim()+ CommonConstants.SALT_KEY), header);
                break;
            default:
                break;
        }
    }
}
