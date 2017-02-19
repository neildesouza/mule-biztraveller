package uk.co.biztraveller.model;

public class Event {
	private String startDateTime;
	private String endDateTime;
	private String subject;
	private String location;
	private String eventSourceSystem;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}
	public String getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Mock Event Constructor
	 * @param variableSubject : Variable Subject to use.
	 */
	public Event (String variableSubject, String sourceSystem) {
		
		this.subject =  variableSubject;
		this.location = "London";
		this.startDateTime = "2015-01-01";
		this.endDateTime="2015-01-04";
		this.eventSourceSystem = sourceSystem;
		
	}
	
	// Empty Constructor for DataWeave
	public Event() {
		
	}
	public String getEventSourceSystem() {
		return eventSourceSystem;
	}
	public void setEventSourceSystem(String eventSourceSystem) {
		this.eventSourceSystem = eventSourceSystem;
	}

}
