package com.mac.springboot.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mac.springboot.controller.ro.in.EventIn;
import com.mac.springboot.controller.ro.out.EventOut;
import com.mac.springboot.domain.Event;
import com.mac.springboot.domain.Technology;
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

		Set<Event> events = new HashSet<Event>() {

			private static final long serialVersionUID = 1L;

			{
				add(EventBuilder.build(event, new HashSet<Technology>(technologyService.updatedEvents(event))));
			}
		};

		for (Event element : events) {
			eventRepository.save(element);
		}

	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EventOut> listAllEvents() {
		List<EventOut> result = new ArrayList<EventOut>();
		for (Event event : eventRepository.findAll()) {
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
