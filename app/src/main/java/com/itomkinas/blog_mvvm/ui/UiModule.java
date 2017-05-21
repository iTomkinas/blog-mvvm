package com.itomkinas.blog_mvvm.ui;

import com.itomkinas.blog_mvvm.api.DataProvider;
import com.itomkinas.blog_mvvm.ui.posts.PostsViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class UiModule {

    @Provides
    PostsViewModel providesPostsViewModel(DataProvider dataProvider) {
        return new PostsViewModel(dataProvider);
    }
}
