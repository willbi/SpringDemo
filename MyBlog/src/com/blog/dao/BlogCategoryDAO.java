package com.blog.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.blog.entity.BlogCategoryEntity;

@Repository(value="BlogCategoryDAO")
public interface BlogCategoryDAO {
	
	public List<BlogCategoryEntity> getBlogCategoryList(BlogCategoryEntity entity);

	public BlogCategoryEntity getBlogCategory(int cateID);
	
	public void addBlogCategory(BlogCategoryEntity entity);
	
	public void updateBlogCategory(BlogCategoryEntity entity);
	
	public void delBlogCategory(int cateID);
}
