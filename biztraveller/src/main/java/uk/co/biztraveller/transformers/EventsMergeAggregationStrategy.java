package uk.co.biztraveller.transformers;

import java.util.ArrayList;
import java.util.List;

import org.mule.DefaultMuleEvent;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.routing.AggregationContext;
import org.mule.api.transport.PropertyScope;
import org.mule.routing.AggregationStrategy;

/**
 * This transformer will take to list as input and create a third one that will be the merge of the previous two. 
 */
public class EventsMergeAggregationStrategy implements AggregationStrategy {
		
	private static final String SYSTEM_UNAVAILABLE_ERROR = "Cannot reach Salesforce or Google Calendar to retrieve events";
	private static final String PARTIAL_SEARCH_SUCCESS_STRING = "partial";
	private static final String FULL_SEARCH_SUCCESS_STRING = "full";
	private static final int TOTAL_EVENTS_TO_PROCESS = 2;

	/**
	 * Aggregate method called as part of the Mule Scatter Gather pattern implementation is the GET /events flow.
	 * @param context Mule Context
	 * @return List of events as an aggregate of Mule events - these are; Salesforce Events, Google Calendar Events
	 * @throw IllegalStateException if no events could be retrieved successfully. 
	 * 
	 */
	@Override
	public MuleEvent aggregate(AggregationContext context) throws MuleException {
		List<MuleEvent> muleEventsWithoutException = context.collectEventsWithoutExceptions();
		int muleEventsWithoutExceptionCount = muleEventsWithoutException.size();
		List<MuleEvent> allEvents = context.getEvents();
		// mule event that will be rewritten
		MuleEvent originalEvent = context.getOriginalEvent();
		// message which payload will be rewritten
		MuleMessage message = originalEvent.getMessage();
		message.setProperty("search_result", FULL_SEARCH_SUCCESS_STRING, PropertyScope.SESSION);
		
		// data should be loaded from both sources - Salesforce and Google Calendar, if not we will return a 'partial' result.
		if (muleEventsWithoutExceptionCount == 0) {
			throw new IllegalStateException(SYSTEM_UNAVAILABLE_ERROR);
		} else if (muleEventsWithoutExceptionCount < TOTAL_EVENTS_TO_PROCESS ) {
			message.setProperty("search_result", PARTIAL_SEARCH_SUCCESS_STRING, PropertyScope.SESSION);
		}
		
		// events are ordered so the event index corresponds to the index of each route
		List<Object> resultEvents = new ArrayList<Object>();
			
		List<Object> googleEvents = getEventsList(allEvents, 0);
		List<Object> salesforceEvents = getEventsList(allEvents, 1);

		resultEvents.addAll(googleEvents) ;
		resultEvents.addAll(salesforceEvents) ;

		message.setPayload(resultEvents);

		return new DefaultMuleEvent(message, originalEvent);
	}

	
	/**
	 * Retrieve list of events from a specified MuleEvent
	 * @param list of MuleEvents related to context
	 * @param index MuleEvent index 
	 * @return events list of events
	 */
	private List<Object> getEventsList(List<MuleEvent> events, int index) {
		MuleEvent event = events.get(index);
		MuleMessage message = event.getMessage();
		if (message.getExceptionPayload() != null ) {
			return new ArrayList<Object>();
		}
		return (List<Object>) message.getPayload();
	}

}
