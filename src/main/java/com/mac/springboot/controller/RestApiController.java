package com.mac.springboot.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mac.springboot.service.EventService;

@RestController
@CrossOrigin
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	private EventService eventService;

	@Autowired
	private MetricService metricService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> ok() {

		return new ResponseEntity<>("ok", HttpStatus.OK);
	}

	@RequestMapping(value = "/cv", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listAllEvents() {

		return ResponseEntity.status(HttpStatus.OK).body(eventService.listAllEvents());
	}

	@RequestMapping(value = "/cv/jobs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listJobEvents() {

		return ResponseEntity.status(HttpStatus.OK).body(eventService.listJobEvents());
	}

	@RequestMapping(value = "/metric", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<?, ?> getStatusMetric() {
		return metricService.getStatusMetric();
	}

}
