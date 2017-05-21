package com.itomkinas.blog_mvvm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.itomkinas.blog_mvvm.api.ApiModule;
import com.itomkinas.blog_mvvm.ui.UiModule;

public class MainApplication extends Application {

    private static MainApplication instance;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDagger();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule(getString(R.string.api_base_url)))
                .uiModule(new UiModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @NonNull
    public static MainApplication getInstance() {
        return instance;
    }
}
