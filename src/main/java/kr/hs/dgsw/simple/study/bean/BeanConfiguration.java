package kr.hs.dgsw.simple.study.bean;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

@Configuration
public class BeanConfiguration {

    @Bean
    public Date march1Movement() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1919);
        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.DATE, 1);

        return new Date(calendar.getTimeInMillis());
    }

    @Bean
    @Primary
    public Date independenceDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1945);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.DATE, 15);

        return new Date(calendar.getTimeInMillis());
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public LifeCycle lifeCycle() {
        return new LifeCycle();
    }


    public static class LifeCycle {

        public void init() {
            LoggerFactory.getLogger(getClass()).info("LifeCycle.init()");
        }

        public void close() {
            LoggerFactory.getLogger(getClass()).info("LifeCycle.close()");
        }
    }

}
