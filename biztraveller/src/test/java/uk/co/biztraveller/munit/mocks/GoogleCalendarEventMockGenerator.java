package uk.co.biztraveller.munit.mocks;

import java.util.ArrayList;
import java.util.Collection;

import uk.co.biztraveller.munit.mocks.model.GoogleCalendarEventMock;
import uk.co.biztraveller.munit.mocks.model.SalesforceEventMock;

public class GoogleCalendarEventMockGenerator {

	public GoogleCalendarEventMockGenerator() {
		// Empty Constructor
	}
	
	public Collection<GoogleCalendarEventMock> getCollectionWith5Events() {
		Collection<GoogleCalendarEventMock> events = new ArrayList<GoogleCalendarEventMock>();
		
		events.add(new GoogleCalendarEventMock("test1",1));
		events.add(new GoogleCalendarEventMock("test2",2));
		events.add(new GoogleCalendarEventMock("test3",3));
		events.add(new GoogleCalendarEventMock("test4",4));
		events.add(new GoogleCalendarEventMock("test5",5));
		
		return events;
		
	}
	
}
