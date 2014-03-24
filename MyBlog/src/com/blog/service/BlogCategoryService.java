package com.blog.service;

import java.util.List;

import com.blog.entity.BlogCategoryEntity;

public interface BlogCategoryService {
	public List<BlogCategoryEntity> getBlogCategoryList(BlogCategoryEntity entity);

	public BlogCategoryEntity getBlogCategory(int cateID);
	
	public void addBlogCategory(BlogCategoryEntity entity);
	
	public void updateBlogCategory(BlogCategoryEntity entity);
	
	public void delBlogCategory(int cateID);
}
