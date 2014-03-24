package com.blog.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.blog.dao.BlogUserDAO;
import com.blog.entity.BlogUserEntity;
import com.blog.service.BlogUserService;

@Repository(value="BlogUserService")
public class BlogUserImpl implements BlogUserService {
	
	@Resource(name="BlogUserDAO")
	private BlogUserDAO blogUserDAO;
	public List<BlogUserEntity> getBlogUserList(BlogUserEntity entity){
		
		return blogUserDAO.getBlogUserList(entity);
	}

	public BlogUserEntity getBlogUser(Map<String,Object> params){
		return blogUserDAO.getBlogUser(params);
	}
	
	public BlogUserEntity getBlogUserByID(int userID){
		return blogUserDAO.getBlogUserByID(userID);
	}
	
	public void addBlogUser(BlogUserEntity entity){
		this.blogUserDAO.addBlogUser(entity);
	}

	@Override
	public void updateBlogUser(BlogUserEntity entity) {
		this.blogUserDAO.updateBlogUser(entity);
	}

	@Override
	public void delBlogUser(int userID) {
		// TODO Auto-generated method stub
		this.blogUserDAO.delBlogUser(userID);
	}

}
