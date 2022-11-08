package com.todo.web.member;

import com.todo.domain.member.MemberDto;
import com.todo.util.WebConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {
    private final WebConverter webConverter;
    private final MemberService memberService;

    @Description("회원가입")
    @PostMapping("/api/member/join")
    public String memberJoin(String data){
        MemberDto.MemberJoinDto memberJoinDto = webConverter.convert(data, MemberDto.MemberJoinDto.class);
        memberService.memberJoin(memberJoinDto);
        return "";
    }

    @Description("회원 탈퇴")
    @PostMapping("/api/member/memberWithdraw")
    public String memberWithdraw(String data){
        MemberDto.MemberWithdrawDto memberWithdrawDto= webConverter.convert(data, MemberDto.MemberWithdrawDto.class);
        memberService.memberWithdraw(memberWithdrawDto);
        return "";
    }

}
