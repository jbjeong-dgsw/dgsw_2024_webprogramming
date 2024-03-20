package kr.hs.dgsw.simple.study.bean;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
//@RequiredArgsConstructor
public class BeanTester {

    private final Date date;

    public BeanTester(@Qualifier("march1Movement") Date date) {
        this.date = date;
    }

    @PostConstruct
    public void printLog() {
        String time =
                new SimpleDateFormat("yyyy-MM-dd")
                        .format(date);

        LoggerFactory.getLogger(getClass()).info("TODAY : {}", time);
    }

}
