package com.blog.common;

import javax.servlet.http.HttpServletRequest;

public class Utils {
	public static boolean isAjaxRequest(HttpServletRequest req) {
		String requestType = req.getHeader("X-Requested-With");
		if (requestType != null && requestType.equals("XMLHttpRequest")) {
			return true;
		} else {
			return false;
		}
	}
}
