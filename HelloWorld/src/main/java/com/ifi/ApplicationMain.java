package com.ifi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApplicationMain implements ApplicationRunner{
	private static Logger logger = LogManager.getLogger(ApplicationMain.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);		
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
