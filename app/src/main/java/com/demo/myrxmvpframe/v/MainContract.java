package com.demo.myrxmvpframe.v;


import com.demo.myrxmvpframe.activities.MainActivity;
import com.demo.myrxmvpframe.m.BaseModel;
import com.demo.myrxmvpframe.net.DefaultObserver;
import com.demo.myrxmvpframe.p.BasePresenter;



/**
 * Created by Administrator on 2017/10/26.
 */

public interface MainContract {

    interface Model extends BaseModel {

        void login(MainActivity activity, String mobile, String pwd, String header, DefaultObserver defaultObserver);

    }

    //当前activity需要实现的方法
    interface View extends BaseView{

    }

    abstract class Presenter extends BasePresenter<Model,View> {

        public abstract void login(MainActivity activity, String mobile, String pwd, String header);

    }
}
