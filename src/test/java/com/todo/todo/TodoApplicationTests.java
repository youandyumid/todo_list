package com.todo.todo;

import com.todo.todo.domain.member.Member;
import com.todo.todo.domain.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
class TodoApplicationTests {
    @Resource
    MemberRepository memberRepository;
    @Resource
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Test
    void memberJoin(){
       Member member = new Member();
       member.setNickName("yjseo");
       member.setActYn(true);
       member.setJoinTime(LocalDateTime.now());
       member.setLoginId("yjseo");
       member.setPwd(encoder.encode("yjseo"));
       member.setNew(true);
       memberRepository.save(member);
    }

}
