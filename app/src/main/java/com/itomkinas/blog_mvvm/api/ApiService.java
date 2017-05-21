package com.itomkinas.blog_mvvm.api;

import com.itomkinas.blog_mvvm.api.models.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

	@GET("posts")
	Observable<List<Post>> getPosts();
}