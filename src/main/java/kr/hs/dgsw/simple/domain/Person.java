package kr.hs.dgsw.simple.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {

    private int idx;

    private String name;

    private String email;

    private int age;

    private String filePath;

}
