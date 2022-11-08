package com.todo.web.todo;

import com.todo.domain.member.Member;
import com.todo.domain.member.MemberRepository;
import com.todo.domain.todo.Todo;
import com.todo.domain.todo.TodoDto;
import com.todo.domain.todo.TodoRepository;
import com.todo.util.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {
    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;
    private final MemberInfo memberInfo;

    @Transactional
    public void write(TodoDto.WriteDto writeDto) {
        Todo todo = new Todo();
        todo.setTodoStatus(writeDto.getTodoStatus());
        todo.setContent(writeDto.getContent());
        Optional<Member> findMember = memberRepository.findById(memberInfo.getMemberId());
        if(!findMember.isPresent()) throw new ValidationException("회원이 존재하지 않습니다.");
        Member member = findMember.get();
        todo.setMember(member);
        todo.setActYn(true);
        todo.setReqTime(LocalDateTime.now());
        todo.setNew(true);
        todoRepository.save(todo);
    }


    public List<Todo> todoListAll() {
        if(memberInfo.getMemberId() == null) throw  new ValidationException("로그인을 해주세요.");
        return todoRepository.findAllByMember_Id(memberInfo.getMemberId());
    }

    public Todo todoListRecent() {
        if(memberInfo.getMemberId() == null) throw  new ValidationException("로그인을 해주세요.");
        return todoRepository.findAllByMember_Id(memberInfo.getMemberId())
                .stream().filter(todo -> todo.getActYn())
                .sorted(Comparator.comparing(Todo::getReqTime).reversed()).findFirst().get();

   }

   @Transactional
    public void changeTodoStatus(TodoDto.ChangeTodoStatusReqDto changeTodoStatusDto) {
      Todo todo = todoRepository.findTodoById(changeTodoStatusDto.getTodoId());
      todo.setTodoStatus(changeTodoStatusDto.getTodoStatus());
   }
}
