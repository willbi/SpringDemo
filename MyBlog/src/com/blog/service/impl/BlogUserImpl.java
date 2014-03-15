package com.blog.service.impl;

import java.util.List;

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

	public BlogUserEntity getBlogUser(String userCode){
		return blogUserDAO.getBlogUser(userCode);
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
