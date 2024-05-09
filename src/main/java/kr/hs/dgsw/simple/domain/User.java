package kr.hs.dgsw.simple.domain;

import kr.hs.dgsw.simple.entity.UserEntity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {
    private int userIdx;

    private String email;

    private String name;

    private String password;

    private int grade;

    private Date registerTime;

    private Date lastLoginTime;

    private String withdrawedYn;

    private Date withdrawedTime;

    public static UserEntity toEntity(User user) {
        UserEntity entity = UserEntity.builder()
                .userIdx(user.getUserIdx())
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .grade(user.getGrade())
                .registerTime(user.getRegisterTime())
                .lastLoginTime(user.getLastLoginTime())
                .withdrawedYn(user.getWithdrawedYn())
                .withdrawedTime(user.getWithdrawedTime())
                .build();

        return entity;
    }

    public static User toDomain(UserEntity entity) {
        User domain = User.builder()
                .userIdx(entity.getUserIdx())
                .email(entity.getEmail())
                .name(entity.getName())
                .password(entity.getPassword())
                .grade(entity.getGrade())
                .registerTime(entity.getRegisterTime())
                .lastLoginTime(entity.getLastLoginTime())
                .withdrawedYn(entity.getWithdrawedYn())
                .withdrawedTime(entity.getWithdrawedTime())
                .build();

        return domain;

    }

}
