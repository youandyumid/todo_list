package com.todo.web.member;

import com.mysql.cj.log.Log;
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
public class LoginController {
    private final WebConverter webConverter;
    private final LoginService loginService;

    @Description("회원가입")
    @PostMapping("/api/common/login")
    public Boolean login(String data){
        MemberDto.LoginDto loginDto = webConverter.convert(data, MemberDto.LoginDto.class);
        return loginService.login(loginDto);
    }
}
