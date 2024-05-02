package kr.hs.dgsw.simple.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reply")
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int replyIdx;

    @Column(name = "writing_idx")
    private int writingIdx;

    private String content;

    private String writer;

    private Date writeTime;
}
