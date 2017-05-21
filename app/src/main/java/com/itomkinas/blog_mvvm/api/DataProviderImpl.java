package com.itomkinas.blog_mvvm.api;

import com.itomkinas.blog_mvvm.api.models.Post;

import java.util.List;

import io.reactivex.Observable;

public class DataProviderImpl implements DataProvider{

    private ApiService apiService;

    public DataProviderImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<List<Post>> getPosts() {
        return apiService.getPosts();
    }
}
