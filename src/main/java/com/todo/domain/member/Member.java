package com.todo.domain.member;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Table(name = "member")
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    @Column(name="memberId", nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String loginId;

    @Column(nullable = false, length = 100)
    private String pwd;

    @Column(nullable = false, length = 100)
    private String nickName;

    @Column(nullable = false)
    private Boolean actYn;

    @Column(nullable = false)
    private LocalDateTime joinTime;

    private LocalDateTime withdrawTime;

    @Transient
    private boolean isNew = false;
}
