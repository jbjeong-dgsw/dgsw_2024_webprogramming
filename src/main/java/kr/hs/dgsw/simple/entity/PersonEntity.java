package kr.hs.dgsw.simple.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String name;

    private String email;

    private int age;

    @Column(name = "file_path")
    private String filePath;

}
