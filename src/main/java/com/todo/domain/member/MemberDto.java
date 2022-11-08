package com.todo.domain.member;

import jdk.jfr.Description;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MemberDto {
    @Description("로그인")
    @Data
    public static class LoginDto{
        @NotNull(message = "로그인 ID는 필수값입니다.")
        private String loginId;

        @NotNull(message = "비밀번호는 필수값입니다.")
        private String pwd;

    }

    @Description("회원 가입")
    @Data
    public static class MemberJoinDto{
        @NotNull(message = "로그인 ID는 필수값입니다.")
        private String loginId;

        @NotNull(message = "비밀번호는 필수값입니다.")
        private String pwd;

        @NotNull(message = "닉네임은 필수값입니다.")
        private String nickName;

    }

    @Description("회원 탈퇴")
    @Data
    public static class MemberWithdrawDto {
        private Long memberId;
    }
}
