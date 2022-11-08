package com.todo.web.member;

import com.todo.domain.member.Member;
import com.todo.domain.member.MemberDto;
import com.todo.domain.member.MemberRepository;
import com.todo.util.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.ValidationException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoginService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final MemberInfo memberInfo;

    public Boolean login(MemberDto.LoginDto loginDto) {
        Member member = memberRepository.findMemberByLoginId(loginDto.getLoginId());
        if(member == null ) throw new ValidationException("회원정보가 없습니다.");
        if(encoder.matches(member.getPwd(),loginDto.getPwd())){
            memberInfo.setMemberId(member.getId());
            memberInfo.setNickName(member.getNickName());
            return true;
        }else return false;
    }
}
