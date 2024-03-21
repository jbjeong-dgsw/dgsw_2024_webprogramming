package kr.hs.dgsw.simple.service.impl.counter;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
//@Scope("prototype")
public class CounterBean {

    private int count = 0;

    @PostConstruct
    public void created() {
        LoggerFactory.getLogger(getClass()).info("CounterBean created");
    }

    @PreDestroy
    public void destructed() {
        LoggerFactory.getLogger(getClass()).info("CounterBean destructed");
    }

    public int increase() {
        return ++count;
    }

    public int getCount() {
        return count;
    }
}
