package com.ifi.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"vietnam", "default"})
public class VietNamService implements HelloWorldService {

    @Override
    public String helloWorld() {
        return "Chao the gioi";
    }

}
