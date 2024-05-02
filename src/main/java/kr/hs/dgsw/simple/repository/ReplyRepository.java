package kr.hs.dgsw.simple.repository;

import kr.hs.dgsw.simple.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {
}
