package com.blog.dao;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.blog.common.PageEntity;
import com.blog.entity.BlogContentEntity;

@Repository(value="BlogContentDAO")
public interface BlogContentDAO {
	public List<BlogContentEntity> getBlogContentList(BlogContentEntity entity,PageEntity page);

	public BlogContentEntity getBlogContent(int blogID);
	
	public void addBlogContent(BlogContentEntity entity);
	
	public void updateBlogContent(BlogContentEntity entity);
	
	public void delBlogContent(int blogID);
}
