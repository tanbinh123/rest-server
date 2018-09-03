
package com.mac.springboot.controller.ro.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "companyName", "projectName", "type", "startDate", "endDate", "technologies" })
public class EventIn {

	@JsonProperty("companyName")
	private String companyName;
	@JsonProperty("logoUrl")
	private String logoUrl;
	@JsonProperty("projectName")
	private String projectName;
	@JsonProperty("type")
	private String type;
	@JsonProperty("startDate")
	private String startDate;
	@JsonProperty("endDate")
	private String endDate;
	@JsonProperty("current")
	private Boolean current;
	@JsonProperty("position")
	private String position;
	@JsonProperty("technologies")
	private List<String> technologies = null;
	@JsonProperty("responsibilities")
	private List<String> responsibilities = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("companyName")
	public String getCompanyName() {
		return companyName;
	}

	@JsonProperty("companyName")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@JsonProperty("logoUrl")
	public String getlogoUrl() {
		return logoUrl;
	}

	@JsonProperty("logoUrl")
	public void setlogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	@JsonProperty("projectName")
	public String getProjectName() {
		return projectName;
	}

	@JsonProperty("projectName")
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("startDate")
	public String getStartDate() {
		return startDate;
	}

	@JsonProperty("startDate")
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@JsonProperty("endDate")
	public String getEndDate() {
		return endDate;
	}

	@JsonProperty("endDate")
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@JsonProperty("current")
	public Boolean getCurrent() {
		return current;
	}

	@JsonProperty("current")
	public void setCurrent(Boolean current) {
		this.current = current;
	}

	@JsonProperty("position")
	public String getPosition() {
		return position;
	}

	@JsonProperty("position")
	public void setPosition(String position) {
		this.position = position;
	}

	@JsonProperty("technologies")
	public List<String> getTechnologies() {
		return technologies;
	}

	@JsonProperty("technologies")
	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}

	@JsonProperty("responsibilities")
	public List<String> getResponsibilities() {
		return responsibilities;
	}

	@JsonProperty("responsibilities")
	public void setResponsibilities(List<String> responsibilities) {
		this.responsibilities = responsibilities;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "EventIn [companyName=" + companyName + ", projectName=" + projectName + ", type=" + type
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", current=" + current + ", position="
				+ position + ", technologies=" + technologies + ", responsibilities=" + responsibilities
				+ ", additionalProperties=" + additionalProperties + "]";
	}

}
