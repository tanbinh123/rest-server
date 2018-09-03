
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
@JsonPropertyOrder({ "name", "phone", "description", "technologies", "events" })
public class CVIn {

	@JsonProperty("name")
	private String name;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("description")
	private String description;
	@JsonProperty("technologies")
	private List<String> technologies = null;
	@JsonProperty("events")
	private List<EventIn> events = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("phone")
	public String getPhone() {
		return phone;
	}

	@JsonProperty("phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("technologies")
	public List<String> getTechnologies() {
		return technologies;
	}

	@JsonProperty("technologies")
	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}

	@JsonProperty("events")
	public List<EventIn> getEvents() {
		return events;
	}

	@JsonProperty("events")
	public void setEvents(List<EventIn> events) {
		this.events = events;
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
		return "CVIn [name=" + name + ", phone=" + phone + ", description=" + description + ", technologies="
				+ technologies + ", events=" + events + ", additionalProperties=" + additionalProperties + "]";
	}

}
