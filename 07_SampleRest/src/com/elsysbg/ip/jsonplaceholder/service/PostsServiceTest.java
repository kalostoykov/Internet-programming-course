package com.elsysbg.ip.jsonplaceholder.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.elsysbg.ip.jsonplaceholder.model.Post;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PostsServiceTest {

	private PostsService postsService;

	@Before
	public void setUp() throws Exception {
		postsService = new PostsService();
	}

	@Test
	public void testCreateGetPost() {
		final Post post = new Post();
		post.setTitle("hello");
		post.setBody("world");
		final Post result = postsService.createPost(post);
		assertNotEquals(0, result.getId());

		final Post fromService = postsService.getPost(post.getId());
		assertEquals("hello", fromService.getTitle());
		assertEquals("world", fromService.getBody());		
	}
}
