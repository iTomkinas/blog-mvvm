package com.itomkinas.blog_mvvm;

import com.itomkinas.blog_mvvm.api.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
}
