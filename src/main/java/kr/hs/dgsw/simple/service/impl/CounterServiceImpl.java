package kr.hs.dgsw.simple.service.impl;

import kr.hs.dgsw.simple.service.CounterService;
import kr.hs.dgsw.simple.service.impl.counter.CounterBean;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService {

    private final CounterBean counterBean;

    public CounterServiceImpl(CounterBean counterBean) {
        this.counterBean = counterBean;
    }

    @Override
    public int increase() {
        return counterBean.increase();
    }
}
