package com.itomkinas.blog_mvvm.ui.posts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.itomkinas.blog_mvvm.MainApplication;
import com.itomkinas.blog_mvvm.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    PostsViewModel postsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainApplication.getInstance().getAppComponent().inject(this);
        postsViewModel.loadPosts();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        postsViewModel.onDestroy();
    }
}
