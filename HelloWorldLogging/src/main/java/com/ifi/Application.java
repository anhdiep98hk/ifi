package com.ifi;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ifi.service.HelloWorldService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger logger = LogManager.getLogger(Application.class);

    @Autowired
    private HelloWorldService helloWorldService;

    @Override
    public void run(String... args) throws Exception {
        logger.info(helloWorldService.helloWorld() + " OK");
        logger.warn(helloWorldService.helloWorld() + " WARN");
        logger.error(helloWorldService.helloWorld()+ " Error");
        logger.fatal(helloWorldService.helloWorld()+ " Fatal");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
