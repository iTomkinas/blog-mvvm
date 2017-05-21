package com.itomkinas.blog_mvvm.ui.posts;

import android.support.v7.widget.RecyclerView;

import com.itomkinas.blog_mvvm.api.models.Post;
import com.itomkinas.blog_mvvm.databinding.ItemPostBinding;

class PostViewHolder extends RecyclerView.ViewHolder {

	private final ItemPostBinding binding;

	public PostViewHolder(ItemPostBinding binding) {
		super(binding.getRoot());
		this.binding = binding;
	}

	public void bind(Post post) {
		binding.setPost(post);
		binding.executePendingBindings();
	}
}
