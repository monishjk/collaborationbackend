package com.Hi5.dao;

import java.util.List;

import com.Hi5.model.BlogComment;

public interface BlogCommentDao 
{
void addBlogComment(BlogComment blogComment);
List<BlogComment> getAllBlogComments(int blogPostId);
void deleteBlogComment(BlogComment blogComment);
}
