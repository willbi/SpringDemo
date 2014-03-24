package com.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.blog.dao.BlogCategoryDAO;
import com.blog.entity.BlogCategoryEntity;
import com.blog.service.BlogCategoryService;


@Repository(value="BlogCategoryService")
public class BlogCategoryImpl implements BlogCategoryService {

	@Resource(name="BlogCategoryDAO")
	private BlogCategoryDAO blogCategoryDAO;
	
	@Override
	public List<BlogCategoryEntity> getBlogCategoryList(
			BlogCategoryEntity entity) {
		// TODO Auto-generated method stub
		return blogCategoryDAO.getBlogCategoryList(entity);
	}

	@Override
	public BlogCategoryEntity getBlogCategory(int cateID) {
		// TODO Auto-generated method stub
		return blogCategoryDAO.getBlogCategory(cateID);
	}

	@Override
	public void addBlogCategory(BlogCategoryEntity entity) {
		// TODO Auto-generated method stub
		blogCategoryDAO.addBlogCategory(entity);
	}

	@Override
	public void updateBlogCategory(BlogCategoryEntity entity) {
		// TODO Auto-generated method stub
		blogCategoryDAO.updateBlogCategory(entity);
	}

	@Override
	public void delBlogCategory(int cateID) {
		// TODO Auto-generated method stub
		blogCategoryDAO.delBlogCategory(cateID);
	}

}
