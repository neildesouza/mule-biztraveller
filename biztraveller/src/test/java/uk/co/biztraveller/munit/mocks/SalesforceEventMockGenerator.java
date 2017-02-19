package uk.co.biztraveller.munit.mocks;

import java.util.ArrayList;
import java.util.Collection;

import uk.co.biztraveller.munit.mocks.model.SalesforceEventMock;

public class SalesforceEventMockGenerator {

	public SalesforceEventMockGenerator() {
		// Empty Constructor
	}
	
	public Collection<SalesforceEventMock> getCollectionWith5Events() {
		Collection<SalesforceEventMock> events = new ArrayList<SalesforceEventMock>();
		
		events.add(new SalesforceEventMock("test1",1));
		events.add(new SalesforceEventMock("test2",2));
		events.add(new SalesforceEventMock("test3",3));
		events.add(new SalesforceEventMock("test4",4));
		events.add(new SalesforceEventMock("test5",5));
		
		return events;
		
	}
	
}
