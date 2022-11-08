package com.todo.domain.todo;

import jdk.jfr.Description;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TodoDto {
    @Description("투두리스트 작성")
    @Data
    public static class WriteDto{
        private TodoStatus todoStatus;

        @NotNull(message = "할 일은 필수입니다.")
        private String content;

        private Long memberId;

    }
    @Description("투두리스트 상태값 바꾸기")
    @Data
    public class ChangeTodoStatusReqDto {
        @NotNull(message = "상태를 변경할 할 일을 선택해주세요.")
        private Long todoId;
        @NotNull(message = "변경할 상태를 선택해주세요.")
        private TodoStatus todoStatus;
    }
}
