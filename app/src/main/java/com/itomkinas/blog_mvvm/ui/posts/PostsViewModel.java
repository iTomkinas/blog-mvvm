package com.itomkinas.blog_mvvm.ui.posts;

import android.view.View;

import com.itomkinas.blog_mvvm.ViewModel;
import com.itomkinas.blog_mvvm.api.DataProvider;
import com.itomkinas.blog_mvvm.api.models.Post;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PostsViewModel implements ViewModel {

    private DataProvider dataProvider;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PostsViewModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public void loadPosts() {
        Disposable disposable = dataProvider.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Post>>() {
                    @Override
                    public void accept(List<Post> posts) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        compositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        dataProvider = null;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
