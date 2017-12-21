package com.demo.myrxmvpframe.p;

/**
 * Created by Administrator on 2017/10/26.
 */

public abstract class BasePresenter<M,V> {

    public M mModel;

    public V mView;

    public void setVM(V v,M m)
    {
        this.mModel=m;
        this.mView=v;
        this.onAttached();
    }

    public abstract void onAttached();

    public void onDetached() {

    }

}
