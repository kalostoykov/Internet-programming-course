package org.elsysbg.ip.jsonplaceholder.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.elsysbg.ip.jsonplaceholder.ServicesTestHelper;
import org.elsysbg.ip.jsonplaceholder.model.Post;
import org.elsysbg.ip.jsonplaceholder.service.PostsService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * For unit testing you can use JUnit or TestNG
 */
public class PostsRestTest {
	private PostsRest postsRest;
	private PostsService postsService;

	@Before
	public void setUp() throws Exception {
		postsService = Mockito.mock(PostsService.class);
		
		ServicesTestHelper.setPostsService(postsService);
		postsRest = new PostsRest();
	}

	@Test
	public void testSetAuthor() {
		final Post post = new Post();
		post.setTitle("hello");
		post.setBody("world");
		
		Mockito.when(postsService.createPost(post)).
			then(new Answer<Post>() {
			@Override
			public Post answer(InvocationOnMock invocation) throws Throwable {
				final Post result = invocation.getArgumentAt(0, Post.class);
				result.setId(1);
				return result;
			}
		});
//		final Post result =
			postsRest.createPost(post);
		
		Mockito.verify(postsService).createPost(post);
		 
		Mockito.verifyNoMoreInteractions(postsService);

//		assertNotNull(result.getAuthor());
//		assertEquals("hello@world", result.getAuthor().getEmail());
//		assertEquals("secret", result.getAuthor().getPassword());
	}
}