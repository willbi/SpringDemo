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
import com.blog.entity.BlogUserEntity;
import com.blog.service.BlogUserService;

@Controller
@RequestMapping("/user")
public class BlogUserController extends AuthController {

	@Resource(name = "BlogUserService")
	private BlogUserService blogUserService;

	@RequestMapping("user")
	public ModelAndView getBlogUserList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("user/userlist");
		BlogUserEntity entity = new BlogUserEntity();
		List<BlogUserEntity> list = this.blogUserService
				.getBlogUserList(entity);
		mav.addObject("userlist", list);
		request.getSession().setAttribute("user_name","will");
		return mav;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public @ResponseBody
	BlogUserEntity addBlogUser(@RequestBody BlogUserEntity entity) {
		if (entity.getUserCode().isEmpty() || entity.getUserName().isEmpty()
				|| entity.getUserPassword().isEmpty()) {
			return entity;
		}
		try {
			this.blogUserService.addBlogUser(entity);
		} catch (Exception e) {
			entity.setUserName(e.getMessage());
		}
		return entity;
	}

	@RequestMapping(value = "del", method = RequestMethod.POST)
	public @ResponseBody
	JsonMsg delBlogUser(@RequestBody String userID) {
		JsonMsg msg = new JsonMsg();
		try {
			System.out.print(userID);
			this.blogUserService.delBlogUser(Integer.parseInt(userID));
			msg.setContent("É¾³ý³É¹¦");
		} catch (Exception e) {
			msg.setCode(-1);
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "searchUser")
	public @ResponseBody
	JsonMsg searchUser(HttpServletRequest request,@RequestBody String query) {
		JsonMsg msg = new JsonMsg();
		try {
			BlogUserEntity queryEntity = (BlogUserEntity) JsonHelper.fromJson(query, BlogUserEntity.class);
			ModelAndView mav = new ModelAndView("user/userresult");
			List<BlogUserEntity> list = this.blogUserService
					.getBlogUserList(queryEntity);
			mav.addObject("userlist", list);
			SpringUtils su = new SpringUtils();
			String evalView = su.renderView(viewResolver, request, mav);
			msg.setContent(evalView);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setCode(-1);
			msg.setMsg(e.getMessage());
		}

		return msg;
	}

}
