package com.lewis.spring.aop06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lewis.spring.aop01.IMath;

public class Test {
	@org.junit.Test
	public void test01() {
		// 容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 从代理工厂中获得代理对象
		IMath math = (IMath) ctx.getBean("proxy");
		int n1 = 100, n2 = 5;
		math.add(n1, n2);
		math.sub(n1, n2);
		math.mut(n1, n2);
		math.div(n1, n2);
	}
}
