package com.blog.common;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.asm.commons.Method;

public class ExceptionLog implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target,
			RuntimeException throwable) {
		System.out.println("�����쳣�ķ������ƣ�  " + method.getName());

		for (Object o : args) {
			System.out.println("�����Ĳ�����   " + o.toString());
		}

		System.out.println("�������   " + target.getClass().getName());
		System.out.println("�׳����쳣:    " + throwable.getMessage() + ">>>>>>>"
				+ throwable.getCause());
		System.out.println("�쳣��ϸ��Ϣ��������" + throwable.fillInStackTrace());
	}
}
