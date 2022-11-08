package com.todo.todo.domain.todo;

import com.todo.todo.domain.member.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Table(name = "todo")
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    @Column(name="todoId", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TodoStatus todoStatus;

    @Column(nullable = false, length = 2000)
    private String content;

    @Column(nullable = false)
    private LocalDateTime reqTime;

    @Column(nullable = false)
    private Boolean actYn;

    @Transient
    private boolean isNew = false;
    //==================================================== 연관관계 ======================================================
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "memberId", referencedColumnName = "memberId", nullable = false)
    private Member member;
}
