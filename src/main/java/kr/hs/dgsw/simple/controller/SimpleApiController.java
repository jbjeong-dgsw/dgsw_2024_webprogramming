package kr.hs.dgsw.simple.controller;

import kr.hs.dgsw.simple.service.GreetingService;
import kr.hs.dgsw.simple.service.impl.GreetingServiceKorean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleApiController {

    @Autowired
    @Qualifier(value = "englishGreetingService")
    private GreetingService greetingService;

    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable(name = "name") String name) {
        return greetingService.sayHello(name);
    }
}
