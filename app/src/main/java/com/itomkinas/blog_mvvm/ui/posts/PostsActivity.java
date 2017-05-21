package com.itomkinas.blog_mvvm.ui.posts;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.itomkinas.blog_mvvm.MainApplication;
import com.itomkinas.blog_mvvm.R;

import javax.inject.Inject;

public class PostsActivity extends AppCompatActivity {

    ViewDataBinding dataBinding;

    @Inject
    PostsViewModel postsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        MainApplication.getInstance().getAppComponent().inject(this);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_posts);
        postsViewModel.loadPosts();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        postsViewModel.onDestroy();
    }
}
