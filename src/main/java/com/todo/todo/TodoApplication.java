package com.todo.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import javax.persistence.Entity;

@SpringBootApplication(scanBasePackages = "com.todo.domain.*" )
@EntityScan("com.todo.domain.*")
@ComponentScan(basePackages = "com.todo.domain.*"
)
@RequiredArgsConstructor
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

}
