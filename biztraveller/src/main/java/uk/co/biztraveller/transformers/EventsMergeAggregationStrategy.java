/**
 * MuleSoft Examples
 * Copyright 2014 MuleSoft, Inc.
 *
 * This product includes software developed at
 * MuleSoft, Inc. (http://www.mulesoft.com/).
 */

package uk.co.biztraveller.transformers;

import java.util.List;
import java.util.Map;

import org.mule.DefaultMuleEvent;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.routing.AggregationContext;
import org.mule.routing.AggregationStrategy;

/**
 * This transformer will take to list as input and create a third one that will be the merge of the previous two. The identity of an element of the list is defined by its email.
 */
public class EventsMergeAggregationStrategy implements AggregationStrategy {
	
	@Override
	public MuleEvent aggregate(AggregationContext context) throws MuleException {
		List<MuleEvent> muleEventsWithoutException = context.collectEventsWithoutExceptions();
		int muleEventsWithoutExceptionCount = muleEventsWithoutException.size();
		
		// data should be loaded from both sources - Salesforce and Google Calendar
		if (muleEventsWithoutExceptionCount != 2) {
			
			// probably better to cycle through events
			throw new IllegalStateException("Data from at least one source was not able to be obtained correctly.");
		}
		
		// mule event that will be rewritten
		MuleEvent originalEvent = context.getOriginalEvent();
		// message which payload will be rewritten
		MuleMessage message = originalEvent.getMessage();
		
		// events are ordered so the event index corresponds to the index of each route
		List<Object> googleEvents = getEventsList(muleEventsWithoutException, 0);
		List<Object> salesforceEvents = getEventsList(muleEventsWithoutException, 1);
		
		
		googleEvents.addAll(salesforceEvents);

		message.setPayload(googleEvents.iterator());

		return new DefaultMuleEvent(message, originalEvent);
	}

	private List<Object> getEventsList(List<MuleEvent> events, int index) {
		return (List<Object>) events.get(index).getMessage().getPayload();
	}

}
