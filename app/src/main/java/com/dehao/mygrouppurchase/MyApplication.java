package com.dehao.mygrouppurchase;

import android.app.Application;
import android.content.Context;

import com.dehao.mygrouppurchase.utils.MLog;
import com.dehao.mygrouppurchase.utils.ToastUtil;
import com.orhanobut.logger.Logger;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2016/10/27.
 * MyApplication 全局配置
 */

public class MyApplication extends Application {

    private static Context mContext;
    private final String TAG = "marno";

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        ToastUtil.initToast(getApplicationContext());

        //配置realm
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(mContext).build();
        Realm.setDefaultConfiguration(realmConfig);

        //Logger
        Logger.init(TAG);//隐藏线程信息
        //对意外闪退做处理
        if (!BuildConfig.DEBUG)
            Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
    }

    //手动处理异常信息
    class MyUnCaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread thread, Throwable e) {
            MLog.e(e.toString());
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());

        }
    }



    //全局获取ApplicationContext
    public static Context getAppContext() {
        return mContext;
    }
}
