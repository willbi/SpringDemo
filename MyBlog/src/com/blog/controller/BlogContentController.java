package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.common.AuthController;
import com.blog.common.JsonMsg;

@Controller
@RequestMapping("blog")
public class BlogContentController extends AuthController{
	
	@RequestMapping("addblog")
	public @ResponseBody JsonMsg addBlog(){
		JsonMsg msg = new JsonMsg();
		return msg;
	}

}
