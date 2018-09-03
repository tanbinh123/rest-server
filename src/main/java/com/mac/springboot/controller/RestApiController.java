package com.mac.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mac.springboot.controller.ro.out.EventOut;
import com.mac.springboot.service.EventService;

@RestController
@CrossOrigin
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	private EventService eventService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> ok() {

		return new ResponseEntity<>("ok", HttpStatus.OK);
	}

	@RequestMapping(value = "/cv", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EventOut>> listAllEvents() {

		return new ResponseEntity<>(eventService.listAllEvents(), HttpStatus.OK);
	}

	@RequestMapping(value = "/cv/jobs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EventOut>> listJobEvents() {

		return new ResponseEntity<>(eventService.listJobEvents(), HttpStatus.OK);
	}

}
