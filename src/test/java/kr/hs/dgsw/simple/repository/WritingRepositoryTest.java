package kr.hs.dgsw.simple.repository;

import kr.hs.dgsw.simple.entity.WritingEntity;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class WritingRepositoryTest {

    @Autowired
    private WritingRepository writingRepository;


    @Test
    public void testList() {
        Sort sort = Sort.by(Sort.Direction.DESC, "writingIdx");
        //Pageable pageable = PageRequest.of(0, 7, sort);

        List<WritingEntity> entities = writingRepository.findAll(sort);

        WritingEntity entity = entities.get(0);
        LoggerFactory.getLogger(getClass()).info("entity {}", entity);
    }


}