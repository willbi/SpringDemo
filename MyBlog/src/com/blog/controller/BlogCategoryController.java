package com.blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blog.common.AuthController;
import com.blog.common.JsonHelper;
import com.blog.common.JsonMsg;
import com.blog.common.SpringUtils;
import com.blog.entity.BlogCategoryEntity;
import com.blog.service.BlogCategoryService;

@Controller
@RequestMapping("/cate")
public class BlogCategoryController extends AuthController {

	@Resource(name = "BlogCategoryService")
	private BlogCategoryService blogCategoryService;

	@RequestMapping("index")
	public ModelAndView blogCateManager(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("cate/cateManager");
		BlogCategoryEntity entity = new BlogCategoryEntity();
		List<BlogCategoryEntity> list = this.blogCategoryService
				.getBlogCategoryList(entity);
		mav.addObject("catelist", list);

		return mav;
	}

	@RequestMapping(value = "search")
	public @ResponseBody
	JsonMsg searchBlogCategory(HttpServletRequest request, @RequestBody String query) {
		JsonMsg msg = new JsonMsg();

		BlogCategoryEntity queryEntity = (BlogCategoryEntity) JsonHelper
				.fromJson(query, BlogCategoryEntity.class);
		ModelAndView mav = new ModelAndView("cate/cateResult");
		List<BlogCategoryEntity> list = this.blogCategoryService
				.getBlogCategoryList(queryEntity);
		mav.addObject("catelist", list);
		SpringUtils su = new SpringUtils();
		String evalView = su.renderView(viewResolver, request, mav);
		msg.setContent(evalView);
		return msg;
	}

	@RequestMapping(value = "get", method = RequestMethod.POST)
	public @ResponseBody
	JsonMsg getBlogCategory(HttpServletRequest request,
			@RequestBody String cateID) {
		JsonMsg msg = new JsonMsg();
		ModelAndView mav = new ModelAndView("cate/cateEdit");
		BlogCategoryEntity entity = new BlogCategoryEntity();
		int cate_id = Integer.parseInt(cateID);
		try {
			if (cate_id > 0)
				entity = this.blogCategoryService.getBlogCategory(cate_id);
			mav.addObject("cate", entity);
			SpringUtils su = new SpringUtils();
			String evalView = su.renderView(viewResolver, request, mav);
			msg.setContent(evalView);
		} catch (Exception e) {
			msg.setCode(-1);
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody
	JsonMsg saveBlogCategory(@RequestBody BlogCategoryEntity entity) {
		JsonMsg msg = new JsonMsg();
		if (entity.getCateCode().isEmpty()
				|| entity.getCateName().isEmpty()) {
			msg.setCode(-1);
			msg.setMsg("分类代码和分类名称都不能为空");
		}
		try {
			if (entity.getCateID() > 0)
				this.blogCategoryService.updateBlogCategory(entity);
			else
				this.blogCategoryService.addBlogCategory(entity);
		} catch (Exception e) {
			msg.setCode(-1);
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "del", method = RequestMethod.POST)
	public @ResponseBody
	JsonMsg delBlogUser(@RequestBody String cateID) {
		JsonMsg msg = new JsonMsg();
		try {
			this.blogCategoryService.delBlogCategory(Integer.parseInt(cateID));
		} catch (Exception e) {
			msg.setCode(-1);
			msg.setMsg(e.getMessage());
		}
		return msg;
	}
}
