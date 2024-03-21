package kr.hs.dgsw.simple.service.impl.counter;

import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DLComponent {

    @Autowired
    private ObjectProvider<CounterBean> provider;


    @PostConstruct
    public void testProvider() {
        CounterBean bean1 = provider.getObject();
        CounterBean bean2 = provider.getObject();

        LoggerFactory.getLogger(getClass()).info("SAME {}", (bean1 == bean2));

        bean1.increase();
        LoggerFactory.getLogger(getClass()).info("Count of beans {} {}",
                bean1.getCount(), bean2.getCount());

    }

}
