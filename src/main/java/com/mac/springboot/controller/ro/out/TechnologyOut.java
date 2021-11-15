package com.mac.springboot.controller.ro.out;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mac.springboot.domain.Technology;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TechnologyOut {
	public TechnologyOut() {

	}

	public TechnologyOut(Technology technology) {
		this.name = technology.getName();
	}

	public static Set<TechnologyOut> build(Set<Technology> technologies) {
		Set<TechnologyOut> result = new HashSet<>();
		for (Technology technology : technologies) {
			result.add(new TechnologyOut(technology));
		}
		return result;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
