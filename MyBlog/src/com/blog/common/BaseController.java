package com.blog.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ViewResolver;

public class BaseController {
	@Autowired 
	public ViewResolver viewResolver;
}
