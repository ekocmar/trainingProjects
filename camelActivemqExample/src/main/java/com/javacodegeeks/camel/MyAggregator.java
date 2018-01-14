/**
 * 
 */
package com.javacodegeeks.camel;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 * @author Emrullah Kocmar
 *
 */
public class MyAggregator implements AggregationStrategy
{
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange)
    {
        if (oldExchange == null)
        {
            ArrayList<String> myList = new ArrayList<String>();
            myList.add(newExchange.getIn().getBody().toString());
            newExchange.getIn().setBody(myList);
            return newExchange;
        }

        ArrayList<String> myList = (ArrayList<String>) oldExchange.getIn().getBody();
        
        myList.add(newExchange.getIn().getBody().toString());

        return oldExchange;
    }

}
