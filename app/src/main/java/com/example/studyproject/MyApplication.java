package com.example.studyproject;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.basercorelib.BaseAppliction;


/**
 * @des:
 * @author: wyc
 * @e-mail: wangyongchao@szy.cn
 * @version:
 * @date 2019/3/20 12:02
 */
public class MyApplication extends BaseAppliction {

    @Override
    public void init() {
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init( this );
    }
}
