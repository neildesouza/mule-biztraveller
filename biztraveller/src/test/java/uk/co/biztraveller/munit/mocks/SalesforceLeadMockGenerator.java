package uk.co.biztraveller.munit.mocks;

import java.util.ArrayList;
import java.util.Collection;

import uk.co.biztraveller.munit.mocks.model.SalesforceLeadMock;

public class SalesforceLeadMockGenerator {

	public SalesforceLeadMockGenerator() {
		// Empty Constructor
	}
	
	public Collection<SalesforceLeadMock> getCollectionWith5Leads() {
		Collection<SalesforceLeadMock> leads = new ArrayList<SalesforceLeadMock>();
		
		leads.add(new SalesforceLeadMock("test1"));
		leads.add(new SalesforceLeadMock("test2"));
		leads.add(new SalesforceLeadMock("test3"));
		leads.add(new SalesforceLeadMock("test4"));
		leads.add(new SalesforceLeadMock("test5"));
		
		return leads;
		
	}
	
}
