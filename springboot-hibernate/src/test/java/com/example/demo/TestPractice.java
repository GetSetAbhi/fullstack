package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPractice {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testingMock() {
		List<Integer> list = mock(ArrayList.class);
		list.add(1);
		assertEquals(list.size(), 0);
	}
	
	@Test
	void testingSpy() {
		List<Integer> list = spy(ArrayList.class);
		list.add(1);
		assertEquals(list.size(), 1);
	}

}
