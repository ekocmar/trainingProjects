/**
 * 
 */
package com.javacodegeeks.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Emrullah Kocmar
 *
 */
public class FinalProcessor implements Processor
{

    public void process(Exchange exchange) throws Exception
    {
        Logger log = LoggerFactory.getLogger(getClass());
        log.warn(exchange.getIn().getBody().toString());
    }

}
