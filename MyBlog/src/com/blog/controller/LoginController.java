package com.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.asm.commons.Method;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blog.common.BaseController;
import com.blog.common.JsonMsg;
import com.blog.entity.BlogUserEntity;
import com.blog.service.BlogUserService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	@Resource(name = "BlogUserService")
	private BlogUserService blogUserService;

	@RequestMapping("index")
	public ModelAndView Index() {
		ModelAndView mav = new ModelAndView("login/login");

		return mav;
	}

	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public @ResponseBody JsonMsg doLogin(HttpServletRequest requet,
			@RequestBody BlogUserEntity entity) {
		JsonMsg jsonMsg = new JsonMsg();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userCode", entity.getUserCode());
		params.put("userPassword", entity.getUserPassword());
		entity = this.blogUserService.getBlogUser(params);
		if (entity != null && entity.getUserID() > 0) {
			requet.getSession().setAttribute("UserSession", entity);
		} else {
			jsonMsg.setMsg("用户名或密码不对");
			jsonMsg.setCode(-1);
		}

		return jsonMsg;
	}

	@RequestMapping("user")
	public ModelAndView getBlogUserList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("user/userlist");
		BlogUserEntity entity = new BlogUserEntity();
		List<BlogUserEntity> list = this.blogUserService
				.getBlogUserList(entity);
		mav.addObject("userlist", list);
		System.out.println("test / user");
		request.getSession().setAttribute("user_name", "will");
		return mav;
	}
}
