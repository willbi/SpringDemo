package com.blog.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blog.common.AuthController;
import com.blog.common.JsonMsg;
import com.blog.common.PageEntity;
import com.blog.entity.BlogCategoryEntity;
import com.blog.entity.BlogContentEntity;
import com.blog.entity.BlogUserEntity;
import com.blog.service.BlogCategoryService;
import com.blog.service.BlogContentService;

@Controller
@RequestMapping("blog")
public class BlogContentController extends AuthController {

	@Resource(name = "BlogContentService")
	private BlogContentService blogContentService;
	
	@Resource(name = "BlogCategoryService")
	private BlogCategoryService blogCategoryService;

	@RequestMapping("index")
	public ModelAndView index(HttpServletRequest req) {
		String sPageIndex = req.getParameter("p");
		int pageIndex = 1;
		if (sPageIndex != null && !sPageIndex.isEmpty())
			pageIndex = Integer.parseInt(sPageIndex);
		BlogContentEntity entity = new BlogContentEntity();
		PageEntity page = new PageEntity(pageIndex, 10, "");
		List<BlogContentEntity> list = null;
		try {
			list = this.blogContentService.getBlogContentList(entity, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("blog/index");
		mav.addObject("bloglist", list);
		return mav;
	}

	@RequestMapping("detail")
	public ModelAndView detail(HttpServletRequest req) {
		String id = req.getParameter("id");
		ModelAndView mav = new ModelAndView("blog/detail");
		BlogContentEntity entity = new BlogContentEntity();
		try {
			if (!id.isEmpty())
				entity = this.blogContentService.getBlogContent(Integer
						.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("blog", entity);
		return mav;
	}

	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest req) {
		String id = req.getParameter("id");
		ModelAndView mav = new ModelAndView("blog/add");
		BlogContentEntity entity = new BlogContentEntity();
		try {
			if (id != null && !id.isEmpty())
				entity = this.blogContentService.getBlogContent(Integer
						.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("blog", entity);
		List<BlogCategoryEntity> list =blogCategoryService.getBlogCategoryList(new BlogCategoryEntity());
		mav.addObject("cate", list);
		return mav;
	}

	@RequestMapping("save")
	public @ResponseBody
	JsonMsg saveBlog(HttpServletRequest request,
			@RequestBody BlogContentEntity entity) {
		JsonMsg msg = new JsonMsg();
		try {
			BlogUserEntity user = (BlogUserEntity) request.getSession()
					.getAttribute("UserSession");
			entity.setCreateDateTime(new Date());
			entity.setUserID(user.getUserID());
			
			if (entity.getBlogID() > 0)
				this.blogContentService.updateBlogContent(entity);
			else
				this.blogContentService.addBlogContent(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping("del")
	public @ResponseBody
	JsonMsg delBlog(@RequestBody String id) {
		JsonMsg msg = new JsonMsg();
		int blogID = 0;
		if (id.isEmpty())
			blogID = Integer.parseInt(id);
		try {

			if (blogID > 0)
				this.blogContentService.delBlogContent(blogID);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
