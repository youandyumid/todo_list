package com.todo.domain.todo;

public enum TodoStatus {
    todo("할 일"),
    ing("진행중"),
    done("완료됨")
    ;

    final String description;
    TodoStatus(String description){this.description = description;}
}
