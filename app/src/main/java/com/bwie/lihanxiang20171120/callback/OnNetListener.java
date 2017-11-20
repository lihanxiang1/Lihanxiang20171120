package com.bwie.lihanxiang20171120.callback;

/**
 * Created by Lonely on 2017/11/20.
 */
public interface OnNetListener<T> {
    public void onSuccess(T t);


    public void onFailure(Exception e);
}
