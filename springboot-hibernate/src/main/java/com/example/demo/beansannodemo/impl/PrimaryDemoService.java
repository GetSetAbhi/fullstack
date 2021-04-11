package com.example.demo.beansannodemo.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.beansannodemo.DemoService;

@Service("primaryDemoService")
@Primary
public class PrimaryDemoService implements DemoService, InitializingBean, DisposableBean  {

	@Override
	public void hello() {
		System.out.println("PRIMARY");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("##########################");
		System.out.println("Destroying bean of class " + this.getClass().getSimpleName());
		System.out.println("##########################");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("##########################");
		System.out.println("Created bean of class " + this.getClass().getSimpleName());
		System.out.println("##########################");
		
	}

}
