package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContainnerController {
    @GetMapping(value = "/api/container", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> sayHello() {
        HashMap<String, String> map = new HashMap<>();
        String containerName = "Undefine";
        try {
            containerName = InetAddress.getLocalHost().getHostName();
            map.put("result", "true");
            map.put("data", containerName);
            map.put("code", "200");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            map.put("result", "false");
            map.put("data", containerName);
            map.put("code", "404");
        }

        return map;
    }
}
