package com.lewis.spring.aop04;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice implements MethodBeforeAdvice  {
	/**
	 * method 方法信息 args 参数 target 被代理的目标对象
	 */
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("-----------------前置通知-----------------");
	}
}
