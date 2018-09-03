package com.mac.springboot.controller.ro.out;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.mac.springboot.domain.Event;
import com.mac.springboot.domain.Event.Type;
import com.mac.springboot.domain.Technology;

@SuppressWarnings("unused")
public class EventOut {

	public EventOut() {

	}

	public EventOut(Event event) {
		this.id = event.getId();
		this.companyName = event.getCompanyName();
		this.logoUrl = event.getLogoUrl();
		this.projectName = event.getProjectName();
		this.startDate = event.getStartDate();
		this.endDate = event.getEndDate();
		this.current = event.getCurrent();
		this.type = event.getType();
		this.technologies = TechnologyOut.build(event.getTechnologies());
		this.description = event.getDescription();
		this.position = event.getPosition();
		this.responsibilities = Arrays.asList(event.getResponsibilities().split("\\s*,\\s*"));
	}

	private long id;

	private String companyName;

	private String logoUrl;

	private String projectName;

	private Date startDate;

	private Date endDate;

	private Boolean current;

	private Type type;

	private Set<TechnologyOut> technologies;

	private String position;

	private List<String> responsibilities;

	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getCurrent() {
		return current;
	}

	public void setCurrent(Boolean current) {
		this.current = current;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Set<TechnologyOut> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(Set<TechnologyOut> technologies) {
		this.technologies = technologies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<String> getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(List<String> responsibilities) {
		this.responsibilities = responsibilities;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

}
