package kr.hs.dgsw.simple.service.impl;

import kr.hs.dgsw.simple.domain.Writing;
import kr.hs.dgsw.simple.entity.WritingEntity;
import kr.hs.dgsw.simple.repository.WritingRepository;
import kr.hs.dgsw.simple.service.WritingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WritingServiceImpl implements WritingService {

    private final WritingRepository writingRepository;

    @Override
    public Page<Writing> list(int pageNumber) {
        Sort sort = Sort.by(Sort.Direction.DESC, "writingIdx");
        Pageable pageable = PageRequest.of(pageNumber, 7, sort);

        Page<WritingEntity> page = writingRepository.findAll(pageable);

        return page.map(Writing::toDomain);
    }

}
