package org.elsysbg.ip.jsonplaceholder;

import org.elsysbg.ip.jsonplaceholder.service.PostsService;

public class Services {
	private static PostsService postsService;

	public synchronized static PostsService getPostsService() {
		if (postsService == null) {
			postsService = new PostsService();
		}
		return postsService;
	}

	public static void setPostsService(PostsService postsService) {
		Services.postsService = postsService;
	}
	
	
}
