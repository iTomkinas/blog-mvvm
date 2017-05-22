package com.itomkinas.blog_mvvm.ui.posts;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.itomkinas.blog_mvvm.api.models.Post;
import com.itomkinas.blog_mvvm.databinding.ItemPostBinding;
import com.itomkinas.blog_mvvm.ui.postDetails.PostDetailsActivity;

class PostViewHolder extends RecyclerView.ViewHolder {

	private final ItemPostBinding binding;

	public PostViewHolder(ItemPostBinding binding) {
		super(binding.getRoot());
		this.binding = binding;
	}

	public void bind(final Post post) {
		binding.setPost(post);
		binding.executePendingBindings();
		binding.view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v.getContext().startActivity(PostDetailsActivity.create(v.getContext(), post));
			}
		});
	}
}
