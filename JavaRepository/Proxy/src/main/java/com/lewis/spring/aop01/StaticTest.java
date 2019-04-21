package com.lewis.spring.aop01;

public class StaticTest {
	IMath math = new MathProxy();

	@org.junit.Test
	public void test01() {
		int n1 = 100, n2 = 5;
		math.add(n1, n2);
		math.sub(n1, n2);
		math.mut(n1, n2);
		math.div(n1, n2);
	}
}
