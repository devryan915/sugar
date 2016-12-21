package com.example.app;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by Ryan on 2016/12/21.
 */

public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
