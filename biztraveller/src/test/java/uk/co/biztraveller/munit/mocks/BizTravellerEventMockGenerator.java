package uk.co.biztraveller.munit.mocks;

import java.util.ArrayList;
import java.util.Collection;

import uk.co.biztraveller.model.Event;

public class BizTravellerEventMockGenerator {

	private static final String GOOGLECALENDAR_SOURCE_SYSTEM = "GOOGLE_CALENDAR";
	private static final String SALESFORCE_SOURCE_SYSTEM = "SALESFORCE";

	public BizTravellerEventMockGenerator() {
		// Empty Constructor
	}
	
	public Collection<Event> getCollectionWith3SalesforceEvents() {
		Collection<Event> events = new ArrayList<Event>();
		
		events.add(new Event("sf_test1",SALESFORCE_SOURCE_SYSTEM));
		events.add(new Event("sf_test2",SALESFORCE_SOURCE_SYSTEM));
		events.add(new Event("sf_test3",SALESFORCE_SOURCE_SYSTEM));
		
		return events;
		
	}
	
	public Collection<Event> getCollectionWith2GoogleEvents() {
		Collection<Event> events = new ArrayList<Event>();
		events.add(new Event("google_test1",GOOGLECALENDAR_SOURCE_SYSTEM));
		events.add(new Event("google_test2",GOOGLECALENDAR_SOURCE_SYSTEM));
		
		return events;
		
	}
	
}
