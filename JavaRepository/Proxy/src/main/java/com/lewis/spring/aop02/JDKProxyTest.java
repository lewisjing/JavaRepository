package com.lewis.spring.aop02;


import com.lewis.spring.aop01.*;
import com.lewis.spring.aop01.Math;

public class JDKProxyTest {
	IMath math = (IMath) new DynamicProxy().getProxyObject(new Math());

	@org.junit.Test
	public void test01() {
		int n1 = 100, n2 = 5;
		math.add(n1, n2);
		math.sub(n1, n2);
		math.mut(n1, n2);
		math.div(n1, n2);
	}

}
