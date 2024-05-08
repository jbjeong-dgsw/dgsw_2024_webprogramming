package kr.hs.dgsw.simple.service;

import kr.hs.dgsw.simple.domain.Reply;
import kr.hs.dgsw.simple.domain.Writing;
import org.springframework.data.domain.Page;

public interface WritingService {

    public Page<Writing> list(int pageNumber);

    public Writing get(int idx);

    public Writing add(Writing writing);

    public Writing update(Writing writing);

    public void delete(int idx);


    public Reply addReply(Reply reply);

    public void deleteReply(int idx);
}
