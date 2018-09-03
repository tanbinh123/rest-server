package com.mac.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
		List<String> savedTechnologiesNames = new ArrayList<>();
		List<Technology> savedTechnologies = getSavedTechnologies(newTechnologies);
		List<Technology> allTechnologies = new ArrayList<>();

		if (savedTechnologies != null && !savedTechnologies.isEmpty()) {
			allTechnologies.addAll(savedTechnologies);
			savedTechnologiesNames = savedTechnologies.stream().map(Technology::getName).collect(Collectors.toList());
		}

		for (String technology : newTechnologies) {
			if (!savedTechnologiesNames.contains(technology)) {
				allTechnologies.add(new Technology(technology, null));
			}
		}

		return allTechnologies;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Technology> getSavedTechnologies(List<String> newTechnologies) {
		List<Technology> savedTechnologies = new ArrayList<>();
		for (String newTechnology : newTechnologies) {
			if (getSavedTechnology(newTechnology) != null) {
				savedTechnologies.add(getSavedTechnology(newTechnology));
			}
		}

		return savedTechnologies;
	}

	@Cacheable(value = "techonlogies", key = "#newTechnology", unless = "#result == null")
	private Technology getSavedTechnology(String newTechnology) {
		Optional<Technology> savedTechnologyOpt = technologyRepository.findOneByName(newTechnology);
		if (savedTechnologyOpt.isPresent()) {
			return savedTechnologyOpt.get();
		}
		return null;
	}
}
