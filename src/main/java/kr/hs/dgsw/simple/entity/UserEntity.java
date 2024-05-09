package kr.hs.dgsw.simple.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/*
 CREATE TABLE user (
		user_idx		int unsigned		not null auto_increment,
		email					varchar(100)	not null	unique,
		name					varchar(100)	not null,
		password		varchar(100)	not null,
		grade				tinyint	unsigned	not null default 1,
		register_time			datetime		not null,
		last_login_time		datetime,
		withdrawed_yn		char(1)		not null  default ’N’,
		withdraw_time		datetime,
		PRIMARY KEY (user_idx)
);
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userIdx;

    private String email;

    private String name;

    private String password;

    private int grade;

    @Column(updatable = false)
    private Date registerTime;

    @Column(insertable = false)
    private Date lastLoginTime;

    @Column(insertable = false)
    private String withdrawedYn;

    @Column(name = "withdraw_time", insertable = false)
    private Date withdrawedTime;

}
