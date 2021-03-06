package com.itomkinas.blog_mvvm.api;

import com.itomkinas.blog_mvvm.api.models.Comment;
import com.itomkinas.blog_mvvm.api.models.Post;

import java.util.List;

import io.reactivex.Observable;

public interface DataProvider {

    Observable<List<Post>> getPosts();

    Observable<List<Comment>> getComments(long postId);
}
