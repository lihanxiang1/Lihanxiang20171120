package com.bwie.lihanxiang20171120.view;

import com.bwie.lihanxiang20171120.bean.GoosBean;

import java.util.List;

/**
 * Created by Lonely on 2017/11/20.
 */
public interface IMainActivity {

    public void showList(List<GoosBean.DataBean> groupList, List<List<GoosBean.DataBean.DatasBean>> childList);
}
