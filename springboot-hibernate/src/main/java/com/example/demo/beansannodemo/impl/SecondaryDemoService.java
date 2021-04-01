package com.example.demo.beansannodemo.impl;

import org.springframework.stereotype.Service;

import com.example.demo.beansannodemo.DemoService;

@Service("secondaryDemoService")
public class SecondaryDemoService implements DemoService {

	@Override
	public void hello() {
		System.out.println("SECONDARY");
	}

}
