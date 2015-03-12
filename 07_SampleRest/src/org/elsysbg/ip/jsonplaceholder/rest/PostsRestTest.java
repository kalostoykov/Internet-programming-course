package org.elsysbg.ip.jsonplaceholder.rest;

import static org.junit.Assert.*;

import org.elsysbg.ip.jsonplaceholder.model.Post;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PostsRestTest {

	private PostsRest postsRest;

	@Before
	public void setUp() throws Exception {
		postsRest = new PostsRest();
	}

	@Test
	public void testSetAuthor() {
		final Post post = new Post();
		post.setTitle("hello");
		post.setBody("world");
		final Post result = postsRest.createPost(post);
		assertNotEquals(0, result.getId());
		assertEquals("hello@world", result.getUser().getEmail());
		assertEquals("secret", result.getUser().getPassword());		
	}

}
