package com.ifi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ifi.service.HelloWorldService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("english")
public class TestHelloService {

    @Autowired
    HelloWorldService helloWorldService;

    @Test
    public void testRainingProfile() throws Exception {
        String output = helloWorldService.helloWorld();
        assertThat(output).contains("Hello world");
    }
}
