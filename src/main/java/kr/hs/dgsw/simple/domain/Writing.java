package kr.hs.dgsw.simple.domain;

import kr.hs.dgsw.simple.entity.WritingEntity;
import lombok.*;

import java.util.Date;

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

    public static Writing toDomain(WritingEntity entity) {
        return Writing.builder()
                .writingIdx(entity.getWritingIdx())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .fileName(entity.getFileName())
                .writeTime(entity.getWriteTime())
                .build();
    }
}
