package com.bwie.lihanxiang20171120.model;

import android.os.Handler;
import android.os.Looper;

import com.bwie.lihanxiang20171120.api.Api;
import com.bwie.lihanxiang20171120.bean.GoosBean;
import com.bwie.lihanxiang20171120.callback.OnNetListener;
import com.bwie.lihanxiang20171120.utils.HttpUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Lonely on 2017/11/20.
 */
public class MainModel implements IMainModel {

    private Handler handler = new Handler(Looper.getMainLooper());




    @Override
    public void getGoods(final OnNetListener<GoosBean> onNetListener) {
        HttpUtils.getHttpUtils().doGet(Api.url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final GoosBean goosBean = new Gson().fromJson(string, GoosBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(goosBean);
                    }
                });
            }
        });
    }
}
