package com.interviewdot.demodocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @GetMapping("/docker/{name}")
    public String docker(@PathVariable String name) {
        return "I am running from a docker = " + name;
    }
}
