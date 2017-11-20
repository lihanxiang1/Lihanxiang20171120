package com.bwie.lihanxiang20171120.model;

import com.bwie.lihanxiang20171120.bean.GoosBean;
import com.bwie.lihanxiang20171120.callback.OnNetListener;

/**
 * Created by Lonely on 2017/11/20.
 */
public interface IMainModel {
    public void getGoods(OnNetListener<GoosBean> onNetListener);
}
