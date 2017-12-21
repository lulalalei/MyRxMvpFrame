package com.demo.myrxmvpframe.v;

import android.app.Activity;

import com.demo.myrxmvpframe.beans.LoginBean;
import com.demo.myrxmvpframe.fragments.MineFragment;
import com.demo.myrxmvpframe.m.BaseModel;
import com.demo.myrxmvpframe.net.DefaultObserver;
import com.demo.myrxmvpframe.p.BasePresenter;




/**
 * Created by Administrator on 2017/10/27.
 */

public interface MineContract {

    interface Model extends BaseModel {

        void login(Activity context, MineFragment fragment, String mobile, String pwd, String header, DefaultObserver defaultObserver);

    }

    interface View extends BaseView{

        void updateUserInfo(LoginBean bean);

    }

    abstract class Presenter extends BasePresenter<Model,View> {

        public abstract void login(Activity context, MineFragment fragment, String mobile, String pwd, String header);

    }
}
