package com.mac.springboot.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mac.springboot.controller.ro.in.EventIn;
import com.mac.springboot.domain.Technology;
import com.mac.springboot.repository.TechnologyRepository;

@Service
public class TechnologyService {

	@Autowired
	private TechnologyRepository technologyRepository;

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Technology> updatedEvents(EventIn event) {

		List<String> newTechnologies = event.getTechnologies();

		List<Technology> allTechnologies = new ArrayList<>();
		allTechnologies.addAll(getSavedTechnologies(newTechnologies));
		allTechnologies.addAll(createTechnologiesIfNotExist(newTechnologies));

		return allTechnologies;
	}

	@Cacheable(value = "techonlogies", key = "#newTechnology", unless = "#result == null")
	private List<Technology> getSavedTechnologies(List<String> technolgies) {
		var savedTechnologyOpt = technologyRepository.findByName(technolgies);
		if (savedTechnologyOpt.isPresent()) {
			return savedTechnologyOpt.get();
		}
		return null;
	}

	public HashSet<Technology> uniqueUpdatedTechnologies(EventIn event) {
		return new HashSet<Technology>(updatedEvents(event));
	}

	private List<Technology> createTechnologiesIfNotExist(List<String> newTechnologies) {
		List<Technology> createdTechnologies = new ArrayList<>();

		List<String> savedTechnologiesNames = savedTechnologiesNames(newTechnologies);

		for (String technology : newTechnologies) {
			if (!savedTechnologiesNames.contains(technology)) {
				createdTechnologies.add(new Technology(technology, null));
			}
		}

		return createdTechnologies;
	}

	private List<String> savedTechnologiesNames(List<String> technolgies) {
		List<Technology> savedTechnologies = getSavedTechnologies(technolgies);
		if (savedTechnologies != null && !savedTechnologies.isEmpty()) {
			return savedTechnologies.stream().map(Technology::getName).collect(Collectors.toList());
		}
		return List.of();
	}
}
