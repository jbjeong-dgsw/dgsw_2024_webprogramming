package kr.hs.dgsw.simple.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "writing")
public class WritingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int writingIdx;

    private String title;

    private String content;

    private String writer;

    private String fileName;

    @Column(updatable = false)
    private Date writeTime;

    @OneToMany
    @Column(insertable = false, updatable = false)
    @JoinColumn(name = "writing_idx")
    @OrderBy("reply_idx desc")
    private List<ReplyEntity> replies;
}
