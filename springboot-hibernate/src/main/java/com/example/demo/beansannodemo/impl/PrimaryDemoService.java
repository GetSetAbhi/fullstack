package com.example.demo.beansannodemo.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.beansannodemo.DemoService;

@Service("primaryDemoService")
@Primary
public class PrimaryDemoService implements DemoService {

	@Override
	public void hello() {
		System.out.println("PRIMARY");
	}

}
