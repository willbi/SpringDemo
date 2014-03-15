package com.blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blog.entity.BlogUserEntity;

@Repository(value="BlogUserDAO")
public interface BlogUserDAO {

	public List<BlogUserEntity> getBlogUserList(BlogUserEntity entity);

	public BlogUserEntity getBlogUser(String userCode);
	
	public void addBlogUser(BlogUserEntity entity);
	
	public void updateBlogUser(BlogUserEntity entity);
	
	public void delBlogUser(int userID);
}
