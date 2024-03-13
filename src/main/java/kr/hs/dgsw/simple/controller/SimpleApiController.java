package kr.hs.dgsw.simple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleApiController {

    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable(name = "name") String name) {
        return "안녕하세요. " + name + "씨";
    }
}
