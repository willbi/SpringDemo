package com.blog.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.blog.entity.BlogUserEntity;

public class SecurityInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("After completion handle");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Post-handle");
	}

	@SuppressWarnings("null")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Pre-Handle");
		if (handler != null
				&& handler instanceof HandlerMethod
				&& ((HandlerMethod) handler).getBean() instanceof AuthController) {
			System.out.println(request.getServletPath()); // /user/user
			System.out.println(request.getRequestURI()); // /MyBlog/user/user
			System.out.println(request.getRequestURL()); // http://localhost:8080/MyBlog/user/user
			System.out.println(request.getQueryString()); // user=u&name=t
			BlogUserEntity entity = (BlogUserEntity) request.getSession()
					.getAttribute("UserSession");
			if (entity != null) {
				// 已登录,则判断是否有菜单权限
			} else {
				String timeoutPage = request.getContextPath() + "/login/index";
				// 未登录
				if (Utils.isAjaxRequest(request)) {
					// ajax请求
					response.setHeader("sessionstatus", "timeout");
					response.setHeader("timeoutpage", timeoutPage);
					response.flushBuffer();
				} else {
					// 非ajax请求
					response.sendRedirect(timeoutPage);
				}
				return false;
			}

		}
		return true;
	}

}
