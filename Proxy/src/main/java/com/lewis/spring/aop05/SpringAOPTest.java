package com.lewis.spring.aop05;

import com.lewis.spring.aop01.IMath;
import com.lewis.spring.aop01.Math;

public class SpringAOPTest {
	@org.junit.Test
	public void test01() {
		// 从代理工厂中获得代理对象
		IMath math = (IMath) DynamicProxy.getProxy(new Math());
		int n1 = 100, n2 = 5;
		math.add(n1, n2);
		math.sub(n1, n2);
		math.mut(n1, n2);
		math.div(n1, n2);
	}
}
