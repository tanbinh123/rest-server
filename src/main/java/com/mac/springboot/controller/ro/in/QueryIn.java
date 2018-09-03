package com.mac.springboot.controller.ro.in;

/**
 *
 * @author marco
 */
public class QueryIn {

	private Integer last;

	private TimeUnit timeUnit;

	private String mavgPoints;

	public enum TimeUnit {
		seconds, minutes, hours
	}

	public Integer getLast() {
		return last;
	}

	public void setLast(Integer last) {
		this.last = last;
	}

	public TimeUnit getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}

	public String getMavgPoints() {
		return mavgPoints;
	}

	public void setMavgPoints(String mavgPoints) {
		this.mavgPoints = mavgPoints;
	}

}
