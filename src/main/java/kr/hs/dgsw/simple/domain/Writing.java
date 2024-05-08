package kr.hs.dgsw.simple.domain;

import kr.hs.dgsw.simple.entity.ReplyEntity;
import kr.hs.dgsw.simple.entity.WritingEntity;
import lombok.*;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Writing {
    private int writingIdx;

    private String title;

    private String content;

    private String writer;

    private String fileName;

    private Date writeTime;

    private List<Reply> replies;

    public static Writing toDomain(WritingEntity entity) {
        Writing writing = Writing.builder()
                .writingIdx(entity.getWritingIdx())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .fileName(entity.getFileName())
                .writeTime(entity.getWriteTime())
                .build();

        //LoggerFactory.getLogger("zzz").info("[time] {} {}", entity, writing);
        //List<Reply> list = entity.getReplies().stream().map(Reply::toDomain).toList();
        //writing.setReplies(list);

        return writing;
    }

    public static WritingEntity toEntity(Writing writing) {
        WritingEntity entity = WritingEntity.builder()
                .writingIdx(writing.getWritingIdx())
                .title(writing.getTitle())
                .content(writing.getContent())
                .writer(writing.getWriter())
                .fileName(writing.getFileName())
                .writeTime(writing.getWriteTime())
                .build();

        return entity;
    }

}
