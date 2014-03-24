package com.blog.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler implements HandlerExceptionResolver {

	private StringBuilder getExceptionOutput(HandlerMethod method, Exception e) {
		StringBuilder sb = new StringBuilder();
		sb.append("������   " + method.getBean());
		sb.append("�������ƣ�   " + method.getMethod());
		MethodParameter[] args = method.getMethodParameters();
		for (MethodParameter o : args) {
			sb.append("������   " + method.getMethodParameters());
		}
		sb.append("�׳����쳣��   " + e.getMessage());
		sb.append("�쳣��ϸ��Ϣ��   " + e.fillInStackTrace());
		return sb;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest req,
			HttpServletResponse rep, Object handler, Exception e) {
		// TODO Auto-generated method stub
		HandlerMethod method = (HandlerMethod) handler;
		PrintWriter writer = null;
		try {
			writer = rep.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//todo ��¼��־
		
		if (Utils.isAjaxRequest(req)) {
			JsonMsg msg = new JsonMsg();
			msg.setCode(-1);
			msg.setMsg(getExceptionOutput(method, e).toString());
			try {
				writer.write(JsonHelper.toJson(msg));
			} catch (IOException e1) {
			}
			writer.flush();
			return null;
		} else {
			return new ModelAndView("error");
		}

	}

}
