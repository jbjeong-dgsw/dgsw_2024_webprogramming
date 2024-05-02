package kr.hs.dgsw.simple.service.impl;

import kr.hs.dgsw.simple.domain.Reply;
import kr.hs.dgsw.simple.domain.Writing;
import kr.hs.dgsw.simple.entity.ReplyEntity;
import kr.hs.dgsw.simple.entity.WritingEntity;
import kr.hs.dgsw.simple.repository.ReplyRepository;
import kr.hs.dgsw.simple.repository.WritingRepository;
import kr.hs.dgsw.simple.service.WritingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class WritingServiceImpl implements WritingService {

    private final WritingRepository writingRepository;

    private final ReplyRepository replyRepository;

    @Override
    public Page<Writing> list(int pageNumber) {
        Sort sort = Sort.by(Sort.Order.desc("writingIdx"), Sort.Order.asc("title"));
        Pageable pageable = PageRequest.of(pageNumber, 7, sort);

        Page<WritingEntity> page = writingRepository.findAll(pageable);

        return page.map(Writing::toDomain);
    }

    @Override
    public Reply addReply(Reply reply) {
        ReplyEntity entity = Reply.toEntity(reply);
        entity.setWriteTime(new Date());

        replyRepository.save(entity);
        reply.setReplyIdx(entity.getReplyIdx());

        return reply;
    }
}
