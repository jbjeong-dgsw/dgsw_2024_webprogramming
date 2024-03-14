package kr.hs.dgsw.simple.controller;

import kr.hs.dgsw.simple.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/construct")
@RequiredArgsConstructor
public class SimpleConstructApiController {

    private final GreetingService greetingService;

    /*
    public SimpleConstructApiController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
     */


    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable(name = "name") String name) {
        return greetingService.sayHello(name);
    }
}
