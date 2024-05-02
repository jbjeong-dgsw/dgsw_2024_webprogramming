package kr.hs.dgsw.simple.domain;

import kr.hs.dgsw.simple.entity.ReplyEntity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {

    private int replyIdx;

    private int writingIdx;

    private String content;

    private String writer;

    private Date writeTime;

    public static Reply toDomain(ReplyEntity entity) {
        return Reply.builder()
                .replyIdx(entity.getReplyIdx())
                .writingIdx(entity.getWritingIdx())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .writeTime(entity.getWriteTime())
                .build();
    }

    public static ReplyEntity toEntity(Reply domain) {
        return ReplyEntity.builder()
                .replyIdx(domain.getReplyIdx())
                .writingIdx(domain.getWritingIdx())
                .content(domain.getContent())
                .writer(domain.getWriter())
                .writeTime(domain.getWriteTime())
                .build();
    }
}
