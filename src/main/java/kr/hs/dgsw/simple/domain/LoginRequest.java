package kr.hs.dgsw.simple.domain;

import lombok.*;

@Getter
@Setter
@ToString
public class LoginRequest {

    private String email;

    private String password;

}
