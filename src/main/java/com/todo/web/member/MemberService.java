package com.todo.web.member;

import com.todo.domain.member.Member;
import com.todo.domain.member.MemberDto;
import com.todo.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Transactional
    public void memberJoin(MemberDto.MemberJoinDto memberJoinDto) {
        Member member = new Member();
        member.setNickName(memberJoinDto.getNickName());
        member.setActYn(true);
        member.setJoinTime(LocalDateTime.now());
        member.setLoginId(memberJoinDto.getLoginId());
        member.setPwd(encoder.encode(memberJoinDto.getPwd()));
        member.setNew(true);
        memberRepository.save(member);
    }

    @Transactional
    public void memberWithdraw(MemberDto.MemberWithdrawDto memberWithdrawDto) {
        Optional<Member> findMember = memberRepository.findById(memberWithdrawDto.getMemberId());
        if(!findMember.isPresent()) throw new ValidationException("회원이 없습니다.");

        Member member = findMember.get();
        member.setActYn(false);
        member.setWithdrawTime(LocalDateTime.now());
    }

}
