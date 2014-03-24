package com.blog.service;

import java.util.List;
import java.util.Map;

import com.blog.entity.BlogUserEntity;

public interface BlogUserService {
	
	public List<BlogUserEntity> getBlogUserList(BlogUserEntity entity);

	public BlogUserEntity getBlogUser(Map<String,Object> params);
	
	public BlogUserEntity getBlogUserByID(int userID);
	
	public void addBlogUser(BlogUserEntity entity);
	
	public void updateBlogUser(BlogUserEntity entity);
	
	public void delBlogUser(int userID);
}
