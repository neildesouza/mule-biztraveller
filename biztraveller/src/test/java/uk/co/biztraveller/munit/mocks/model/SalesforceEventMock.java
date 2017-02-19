package uk.co.biztraveller.munit.mocks.model;

/**
 * Mock Salesforce Event Object
 * 
 * @author neildesouza
 * SOQL: SELECT AccountId,ActivityDate,Description,DurationInMinutes,
 * EndDateTime,Location,OwnerId,StartDateTime,Subject,WhoId FROM Event
 */

public class SalesforceEventMock {
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	private String subject;
	private String location;
	private String startDateTime;
	private String endDateTime;
	
	public SalesforceEventMock (String variableSubject, int daysToOffset) {
		this.subject =  variableSubject;
		this.location = "London";
		this.startDateTime = "2015-01-01";
		this.endDateTime="2015-01-04";
		
	}
	
	

}
