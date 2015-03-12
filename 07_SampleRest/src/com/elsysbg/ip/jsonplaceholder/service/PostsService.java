package com.elsysbg.ip.jsonplaceholder.service;

import java.util.LinkedList;
import java.util.List;

import org.elsysbg.ip.jsonplaceholder.model.Post;

public class PostsService {
	
	private final List<Post> posts = new LinkedList<Post>();
	private long lastPostId = 0;
	
	public List<Post> getPosts() {
		return posts;
	}
	
	public Post getPost(long postId) {
		for (Post next : posts) {
			if(next.getId() == postId) {
				return next;
			}
		}
		return null;
	}
	
	public synchronized Post createPost(Post post) {
		lastPostId++;
		post.setId(lastPostId);
		posts.add(post);
		return post;
	}
	
	public Post updatePost(Post post) {
		deletePost(post.getId());
		posts.add(post);
		return post;
	}
	
	// change the return type to void
	public void deletePost(long postId) {
		final Post toBeDeleted = getPost(postId);
		posts.remove(toBeDeleted);
	}
}
