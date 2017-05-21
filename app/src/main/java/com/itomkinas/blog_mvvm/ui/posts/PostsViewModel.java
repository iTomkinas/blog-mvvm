package com.itomkinas.blog_mvvm.ui.posts;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
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

    public final ObservableField<List<Post>> posts = new ObservableField<>();
    public final ObservableBoolean dataLoading = new ObservableBoolean(false);

    private DataProvider dataProvider;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PostsViewModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public void loadPosts() {
        dataLoading.set(true);
        Disposable disposable = dataProvider.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Post>>() {
                    @Override
                    public void accept(List<Post> newPosts) throws Exception {
                        posts.set(newPosts);
                        dataLoading.set(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // TODO: 5/21/17 Implement error handlingt
                        dataLoading.set(false);
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
