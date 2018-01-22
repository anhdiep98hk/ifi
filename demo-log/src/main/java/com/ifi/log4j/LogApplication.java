package com.ifi.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogApplication implements ApplicationRunner{

	private static final Logger logger = LogManager.getLogger(LogApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LogApplication.class, args);		
	}
	
	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		// logger.debug("Debugging log");
        logger.info("Hello world info log");
        logger.warn("Hello world warning!");
        logger.error("Hello world Error. OK");
        logger.fatal("Hello world Fatal error.");
		
	}

}
