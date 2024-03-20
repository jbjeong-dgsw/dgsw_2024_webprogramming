package kr.hs.dgsw.simple.study.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleOfAnnotation {

    @PostConstruct
    public void start() {
        LoggerFactory.getLogger(getClass()).info("LifeCycleOfAnnotation.start()");
    }


    @PreDestroy
    public void stop() {
        LoggerFactory.getLogger(getClass()).info("LifeCycleOfAnnotation.stop()");
    }

}
