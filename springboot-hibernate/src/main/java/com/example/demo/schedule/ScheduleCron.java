package com.example.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleCron {

	@Scheduled(fixedDelay = 3000)
	public void helloSchedule() {
		System.out.println("########Hello");
	}
}
