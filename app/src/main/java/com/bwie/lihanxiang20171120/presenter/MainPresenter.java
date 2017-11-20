package com.bwie.lihanxiang20171120.presenter;

import com.bwie.lihanxiang20171120.bean.GoosBean;
import com.bwie.lihanxiang20171120.callback.OnNetListener;
import com.bwie.lihanxiang20171120.model.IMainModel;
import com.bwie.lihanxiang20171120.model.MainModel;
import com.bwie.lihanxiang20171120.view.IMainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lonely on 2017/11/20.
 */
public class MainPresenter {

    private final IMainModel imainModel;
    private final IMainActivity iMainActivity;


    public MainPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        imainModel = new MainModel();
    }


    public void getGoods() {
        imainModel.getGoods(new OnNetListener<GoosBean>() {
            @Override
            public void onSuccess(GoosBean goosBean) {
                //List<GoosBean.DataBean> groupList, List<List<GoosBean.DataBean.DatasBean>> childList
                List<GoosBean.DataBean> dataBean = goosBean.getData();
                List<List<GoosBean.DataBean.DatasBean>> childList = new ArrayList<List<GoosBean.DataBean.DatasBean>>();
                for (int i = 0; i < dataBean.size(); i++) {
                    List<GoosBean.DataBean.DatasBean> datas = dataBean.get(i).getDatas();
                    childList.add(datas);
                }
                iMainActivity.showList(dataBean, childList);
            }


            @Override
            public void onFailure(Exception e) {


            }
        });


    }

}
