package com.example.studyproject.component.arouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

/**
 * author: wangliyun
 * date: 2020/3/26
 * description:
 */
@Route(path = DegradeServiceImpl.PATH)
public class DegradeServiceImpl implements DegradeService {
    private static final String TAG = "DegradeServiceImpl";
    static final String PATH = "/service/DegradeServiceImpl";

    @Override
    public void onLost(Context context, Postcard postcard) {
        if (context != null && postcard.getGroup().equals("activity_test")) {
            Log.i(TAG, "onLost: 降级处理，没有找到对应页面开启H5页说明情况。");
        }
    }

    @Override
    public void init(Context context) {

    }
}
