package com.git.study.helloworld;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HelloWorldTest{
	@Test
	public void testSayHello(){
		HelloWorld helloworld = new HelloWorld();
		String result = helloworld.sayHello();
		assertEquals("Hello Maven",result);
	}
}