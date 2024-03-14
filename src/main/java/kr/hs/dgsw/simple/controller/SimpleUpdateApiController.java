package kr.hs.dgsw.simple.controller;

import kr.hs.dgsw.simple.service.GreetingService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/update")
public class SimpleUpdateApiController {

    private GreetingService greetingService;

    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        LoggerFactory.getLogger(getClass())
                .info("주입 테스트 : {}", greetingService );
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable(name = "name") String name) {
        return greetingService.sayHello(name);
    }
}
