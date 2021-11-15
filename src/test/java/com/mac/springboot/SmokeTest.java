package com.mac.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.mac.springboot.controller.RestApiController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SmokeTest {

	@Autowired
	private RestApiController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}