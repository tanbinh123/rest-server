package com.mac.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import com.mac.springboot.util.Auth;
import com.mac.springboot.util.Util;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {

		var target = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		assertThat(target).contains("ok");
	}

	@Test
	public void shouldReturnLogin() throws Exception {

		var request = new HttpEntity<String>(Util.toJson(new Auth("admin", "password")));
		HttpEntity<String> response = restTemplate.exchange("https://spring-cv.herokuapp.com/login", HttpMethod.POST,
				request, String.class);

		// String resultString = response.getBody();
		HttpHeaders headers = response.getHeaders();
		
		
		Pattern pattern = Pattern.compile("Bearer");
		var matching = headers.get(HttpHeaders.AUTHORIZATION).stream()
		                            .filter(pattern.asPredicate())
		                            .collect(Collectors.toList());
		assertThat(matching).hasSize(1);
	}
}