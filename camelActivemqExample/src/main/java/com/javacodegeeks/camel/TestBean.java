package com.javacodegeeks.camel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean {
	public String hello(String msg) {
        Logger logger = LoggerFactory.getLogger(getClass());

        logger.info(msg + ":" + Thread.currentThread());

        return msg;
	}
}
