package com.mac.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mac.springboot.controller.ro.in.EventIn;
import com.mac.springboot.controller.ro.out.EventOut;
import com.mac.springboot.domain.Event;
import com.mac.springboot.domain.builder.EventBuilder;
import com.mac.springboot.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private TechnologyService technologyService;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(EventIn event) {
		eventRepository.save(buildNewEvent(event));
	}

	private Event buildNewEvent(EventIn event) {
		return EventBuilder.build(event, technologyService.uniqueUpdatedTechnologies(event));
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EventOut> listAllEvents() {
		List<EventOut> result = new ArrayList<EventOut>();
		var events = eventRepository.findAll();
		for (Event event : events) {
			result.add(new EventOut(event));
		}
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EventOut> listJobEvents() {
		List<EventOut> result = new ArrayList<EventOut>();
		for (Event event : eventRepository.findByType(Event.Type.job)) {
			result.add(new EventOut(event));
		}
		return result;
	}
}
