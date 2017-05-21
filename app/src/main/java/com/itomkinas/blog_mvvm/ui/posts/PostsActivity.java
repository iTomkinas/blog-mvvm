package com.itomkinas.blog_mvvm.ui.posts;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.itomkinas.blog_mvvm.MainApplication;
import com.itomkinas.blog_mvvm.R;
import com.itomkinas.blog_mvvm.api.models.Post;
import com.itomkinas.blog_mvvm.databinding.ActivityPostsBinding;

import java.util.List;

import javax.inject.Inject;

public class PostsActivity extends AppCompatActivity {

    ActivityPostsBinding dataBinding;

    @Inject
    PostsViewModel postsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        MainApplication.getInstance().getAppComponent().inject(this);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_posts);
        dataBinding.setViewModel(postsViewModel);
        postsViewModel.loadPosts();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        postsViewModel.onDestroy();
    }

    @BindingAdapter("app:items")
    public static void setItems(RecyclerView listView, List<Post> items) {
        // TODO: 5/21/17 Implement post list
    }

}
