package com.Hi5.dao;


import com.Hi5.model.BlogComment;
import com.Hi5.model.BlogPost;
import com.Hi5.model.BlogPostLikes;

public interface BlogPostLikesDao
{
	BlogPostLikes hasUserLikedBlogPost(int blogPostId,String email);

	BlogPost updateLikes(int blogPostId, String email);
}
