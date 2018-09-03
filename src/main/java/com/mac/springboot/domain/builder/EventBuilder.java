package com.mac.springboot.domain.builder;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.mac.springboot.controller.ro.in.EventIn;
import com.mac.springboot.domain.Event;
import com.mac.springboot.domain.Event.Type;
import com.mac.springboot.domain.Technology;
import com.mac.springboot.util.Util;

public class EventBuilder {

	public static Event newEvent(String companyName, String projectName, String position, Date startDate, Date endDate,
			Boolean current, Type type, Set<Technology> technologies, String description, String responsibilities) {

		Event event = new Event();
		event.setCompanyName(companyName);
		event.setProjectName(projectName);
		event.setPosition(position);
		event.setStartDate(startDate);
		event.setEndDate(endDate);
		event.setCurrent(current);
		event.setType(type);
		event.setTechnologies(technologies);
		event.setDescription(description);
		event.setResponsibilities(responsibilities);
		return event;

	}

	public static Event build(EventIn eventIn, HashSet<Technology> technologies) throws InvalidParameterException {
		try {
			Event newEvent = new Event();
			newEvent.setCompanyName(eventIn.getCompanyName());
			newEvent.setProjectName(eventIn.getProjectName());
			newEvent.setPosition(eventIn.getPosition());
			newEvent.setStartDate(Util.parseDate(eventIn.getStartDate()));
			newEvent.setEndDate(Util.parseDate(eventIn.getEndDate()));
			newEvent.setCurrent(eventIn.getCurrent());
			newEvent.setType(Type.valueOf(eventIn.getType()));
			newEvent.setTechnologies(technologies);
			newEvent.setLogoUrl(eventIn.getlogoUrl());
			newEvent.setResponsibilities(String.join(",", eventIn.getResponsibilities()));
			return newEvent;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new InvalidParameterException("Please check input log for some invalid parameter");
		}
	}
}
