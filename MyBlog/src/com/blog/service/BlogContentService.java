package com.blog.service;

import java.util.List;

import com.blog.common.PageEntity;
import com.blog.entity.BlogContentEntity;

public interface BlogContentService {
	public List<BlogContentEntity> getBlogContentList(BlogContentEntity entity,PageEntity page);

	public BlogContentEntity getBlogContent(int blogID);
	
	public void addBlogContent(BlogContentEntity entity);
	
	public void updateBlogContent(BlogContentEntity entity);
	
	public void delBlogContent(int blogID);
}
