package com.blog.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.blog.entity.BlogUserEntity;

@Repository(value="BlogUserDAO")
public interface BlogUserDAO {

	public List<BlogUserEntity> getBlogUserList(BlogUserEntity entity);

	public BlogUserEntity getBlogUser(Map<String,Object> params);
	
	public BlogUserEntity getBlogUserByID(int userID);
	
	public void addBlogUser(BlogUserEntity entity);
	
	public void updateBlogUser(BlogUserEntity entity);
	
	public void delBlogUser(int userID);
}
