package kr.hs.dgsw.simple.study.bean;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleOfInterface implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        LoggerFactory.getLogger(getClass()).info("LifeCycleOfInterface.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {

    }
}
