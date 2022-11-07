package com.todo.domain.member;

import jdk.jfr.Description;
import lombok.Data;

@Data
public class MemberDto {

    @Description("회원 가입")
    @Data
    public static class MemberJoinDto{
        private Long memberId;
        private String nickName;

        public static MemberJoinDto of(Long memberId,String nickName){
            MemberJoinDto dto = new MemberJoinDto();
            dto.setMemberId(memberId);
            dto.setNickName(nickName);
            return dto;
        }
    }

    @Description("회원 탈퇴")
    public static class MemberDeleteDto{
        private Long memberId;
    }
}
