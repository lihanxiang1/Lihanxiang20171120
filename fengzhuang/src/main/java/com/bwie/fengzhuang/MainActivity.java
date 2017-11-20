package com.bwie.fengzhuang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data();
    }

    private void Data() {

        HashMap<String, String> map = new HashMap<>();
        map.put("uid","71");

        OkhttpUtils.getInstance().asy(map, "https://www.zhaoapi.cn/product/getOrders", new AbstractUiCallBack<ShopBean>() {


            @Override
            public void success(ShopBean shopBean) {

                List<ShopBean.DataBean> list = shopBean.getData();
                System.out.println("list = " + list);

            }

            @Override
            public void failure(Exception e) {

            }
        });


    }


}
