package com.blog.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blog.common.AuthController;
import com.blog.common.BaseController;
import com.blog.common.JsonHelper;
import com.blog.common.JsonMsg;
import com.blog.common.SpringUtils;
import com.blog.entity.BlogCategoryEntity;
import com.blog.entity.BlogUserEntity;
import com.blog.service.BlogUserService;

@Controller
@RequestMapping("/user")
public class BlogUserController extends AuthController {

	@Resource(name = "BlogUserService")
	private BlogUserService blogUserService;

	@RequestMapping("index")
	public ModelAndView getBlogUserList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("user/userManager");
		BlogUserEntity entity = new BlogUserEntity();
		List<BlogUserEntity> list = this.blogUserService
				.getBlogUserList(entity);
		mav.addObject("userlist", list);
		
		return mav;
	}

	@RequestMapping(value = "search")
	public @ResponseBody
	JsonMsg searchUser(HttpServletRequest request, @RequestBody String query) {
		JsonMsg msg = new JsonMsg();
		BlogUserEntity queryEntity = (BlogUserEntity) JsonHelper.fromJson(
				query, BlogUserEntity.class);
		ModelAndView mav = new ModelAndView("user/userResult");
		List<BlogUserEntity> list = this.blogUserService
				.getBlogUserList(queryEntity);
		mav.addObject("userlist", list);
		SpringUtils su = new SpringUtils();
		String evalView = su.renderView(viewResolver, request, mav);
		msg.setContent(evalView);
		return msg;
	}

	@RequestMapping(value = "get", method = RequestMethod.POST)
	public @ResponseBody
	JsonMsg getBlogCategory(HttpServletRequest request,
			@RequestBody String userID) {
		JsonMsg msg = new JsonMsg();
		ModelAndView mav = new ModelAndView("user/userEdit");
		BlogUserEntity entity = new BlogUserEntity();
		int user_id = Integer.parseInt(userID);
		try {
			if (user_id > 0)
				entity = this.blogUserService.getBlogUserByID(user_id);
			mav.addObject("user", entity);
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
	JsonMsg saveBlogUser(@RequestBody BlogUserEntity entity) {
		JsonMsg msg = new JsonMsg();
		if (entity.getUserCode().isEmpty() || entity.getUserName().isEmpty()
				|| entity.getUserPassword().isEmpty()) {
			msg.setCode(-1);
			msg.setMsg("用户代码和用户名称都不能为空");
		}
		try {
			if (entity.getUserID() > 0)
				this.blogUserService.updateBlogUser(entity);
			else
				this.blogUserService.addBlogUser(entity);
		} catch (Exception e) {
			msg.setCode(-1);
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "del", method = RequestMethod.POST)
	public @ResponseBody
	JsonMsg delBlogUser(@RequestBody String userID) {
		JsonMsg msg = new JsonMsg();
		try {
			this.blogUserService.delBlogUser(Integer.parseInt(userID));
		} catch (Exception e) {
			msg.setCode(-1);
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

}
