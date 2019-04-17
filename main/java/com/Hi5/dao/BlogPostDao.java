package com.Hi5.dao;

import java.util.List;


import com.Hi5.model.BlogComment;
import com.Hi5.model.BlogPost;
public interface BlogPostDao
{
 void addBlogPost(BlogPost blogPost);
 List<BlogPost> getBlogsApproved();
 List<BlogPost> getBlogsWaitingForApproval();
 BlogPost getBlog(int blogPostId);
 void approveBlogPost(BlogPost blogPost);
 void rejectBlogPost(BlogPost blogPost);
}
