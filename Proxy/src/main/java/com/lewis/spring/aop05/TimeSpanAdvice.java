package com.lewis.spring.aop05;

import java.util.Random;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimeSpanAdvice implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 被织入的横切内容，开始时间 before
		long start = System.currentTimeMillis();
		lazy();

		// 方法调用
		Object result = invocation.proceed();

		// 被织入的横切内容，结束时间
		Long span = System.currentTimeMillis() - start;
		System.out.println("共用时：" + span);

		return result;
	}

	// 模拟延时
	public void lazy() {
		try {
			int n = (int) new Random().nextInt(500);
			Thread.sleep(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
