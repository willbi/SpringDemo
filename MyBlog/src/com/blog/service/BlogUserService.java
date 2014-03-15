package com.blog.service;

import java.util.List;

import com.blog.entity.BlogUserEntity;

public interface BlogUserService {
	
	public List<BlogUserEntity> getBlogUserList(BlogUserEntity entity);

	public BlogUserEntity getBlogUser(String userCode);
	
	public void addBlogUser(BlogUserEntity entity);
	
	public void updateBlogUser(BlogUserEntity entity);
	
	public void delBlogUser(int userID);
}
