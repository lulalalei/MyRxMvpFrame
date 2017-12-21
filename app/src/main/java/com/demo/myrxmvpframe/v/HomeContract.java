package com.demo.myrxmvpframe.v;

import android.app.Activity;

import com.demo.myrxmvpframe.fragments.HomeFragment;
import com.demo.myrxmvpframe.m.BaseModel;
import com.demo.myrxmvpframe.net.DefaultObserver;
import com.demo.myrxmvpframe.p.BasePresenter;




/**
 * Created by Administrator on 2017/10/27.
 */

public interface HomeContract {

    interface Model extends BaseModel {

        void getHomeProduct(Activity activity, HomeFragment fragment, String userId, DefaultObserver defaultObserver);

    }

    interface View extends BaseView{

    }

    abstract class Presenter extends BasePresenter<Model,View> {

        public abstract void getHomeProduct(Activity activity, HomeFragment fragment,String userId);
    }
}
