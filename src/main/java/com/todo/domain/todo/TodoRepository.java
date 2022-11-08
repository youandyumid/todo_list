package com.todo.domain.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
    List<Todo> findAllByMember_Id(Long memberId);
    Todo findTodoById(Long todoId);
}
