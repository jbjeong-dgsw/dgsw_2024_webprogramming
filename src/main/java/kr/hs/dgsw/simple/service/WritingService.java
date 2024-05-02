package kr.hs.dgsw.simple.service;

import kr.hs.dgsw.simple.domain.Reply;
import kr.hs.dgsw.simple.domain.Writing;
import org.springframework.data.domain.Page;

public interface WritingService {

    public Page<Writing> list(int pageNumber);


    public Reply addReply(Reply reply);
}
