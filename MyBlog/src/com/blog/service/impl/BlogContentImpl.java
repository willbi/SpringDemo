package com.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.blog.common.PageEntity;
import com.blog.dao.BlogCategoryDAO;
import com.blog.dao.BlogContentDAO;
import com.blog.entity.BlogContentEntity;
import com.blog.service.BlogContentService;

@Repository(value="BlogContentService")
public class BlogContentImpl implements BlogContentService {

	@Resource(name="BlogContentDAO")
	private BlogContentDAO blogContentDAO;
	
	@Override
	public List<BlogContentEntity> getBlogContentList(BlogContentEntity entity,PageEntity page) {
		// TODO Auto-generated method stub
		 Map<String,Object> params = new HashMap<String, Object>();
		 params.put("entity",entity);
		 params.put("page",page);
		return blogContentDAO.getBlogContentList(entity,page);
	}

	@Override
	public BlogContentEntity getBlogContent(int blogID) {
		// TODO Auto-generated method stub
		return blogContentDAO.getBlogContent(blogID);
	}

	@Override
	public void addBlogContent(BlogContentEntity entity) {
		// TODO Auto-generated method stub
		blogContentDAO.addBlogContent(entity);
	}

	@Override
	public void updateBlogContent(BlogContentEntity entity) {
		// TODO Auto-generated method stub
		blogContentDAO.updateBlogContent(entity);
	}

	@Override
	public void delBlogContent(int blogID) {
		// TODO Auto-generated method stub
		blogContentDAO.delBlogContent(blogID);
	}

}
