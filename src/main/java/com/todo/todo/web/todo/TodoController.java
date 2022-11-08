package com.todo.todo.web.todo;

import com.todo.todo.domain.todo.Todo;
import com.todo.todo.domain.todo.TodoDto;
import com.todo.todo.util.WebConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TodoController {
    private final WebConverter webConverter;
    private final TodoService todoService;

    @Description("todo-list 작성")
    @PostMapping("/api/todo/write")
    public String write(String data){
        TodoDto.WriteDto writeDto = webConverter.convert(data, TodoDto.WriteDto.class);
        todoService.write(writeDto);
        return "";
    }


    @Description("todo-list 조회 - 전체")
    @GetMapping("/api/todo/todoListAll")
    public List<Todo> todoListAll(){
        return todoService.todoListAll();
    }

    @Description("todo-list 조회 - 최근")
    @GetMapping("/api/todo/todoListRecent")
    public Todo todoListRecent(){
        return todoService.todoListRecent();
    }

    @Description("todo-list 상태 수정")
    @PostMapping("/api/todo/changeTodoStatus")
    public String changeTodoStatus(String data){
        TodoDto.ChangeTodoStatusReqDto changeTodoStatusDto = webConverter.convert(data, TodoDto.ChangeTodoStatusReqDto.class);
        todoService.changeTodoStatus(changeTodoStatusDto);
        return "";
    }
}
