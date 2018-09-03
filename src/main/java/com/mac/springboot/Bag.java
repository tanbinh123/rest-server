package com.mac.springboot;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import com.mac.springboot.controller.ro.in.CVIn;
import com.mac.springboot.controller.ro.in.EventIn;
import com.mac.springboot.service.EventService;

@Component
public class Bag {

	@Autowired
	private EventService eventService;

	@Bean
	public Boolean sendDatabase() throws IOException {
		Yaml yaml = new Yaml();
		try (InputStream in = Bag.class.getResourceAsStream("/data.yaml")) {
			CVIn cv = yaml.loadAs(in, CVIn.class);
			System.out.println(cv);
			for (EventIn event : cv.getEvents()) {
				eventService.insert(event);
			}
		}
		return true;

	}

	@Bean
	public CacheManager cacheManager() {
		ConcurrentMapCacheManager cache = new ConcurrentMapCacheManager("techonlogies");
		return cache;
	}
}
