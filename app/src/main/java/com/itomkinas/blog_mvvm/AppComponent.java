package com.itomkinas.blog_mvvm;

import com.itomkinas.blog_mvvm.api.ApiModule;
import com.itomkinas.blog_mvvm.ui.UiModule;
import com.itomkinas.blog_mvvm.ui.posts.PostsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class, UiModule.class})
public interface AppComponent {

    void inject(PostsActivity postsActivity);
}
