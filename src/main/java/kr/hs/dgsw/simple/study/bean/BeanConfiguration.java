package kr.hs.dgsw.simple.study.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.Date;

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
    public Date independenceDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1945);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.DATE, 15);

        return new Date(calendar.getTimeInMillis());
    }

}
