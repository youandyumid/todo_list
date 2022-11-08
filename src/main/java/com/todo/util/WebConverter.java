package com.todo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class WebConverter {
    public <T> T convert(String data, Class<T> voClass) {
        //dto로 변환.
        ObjectMapper mapper = new ObjectMapper();
        Gson gson = new Gson();
        T dto = gson.fromJson(data, voClass);
        return dto;
    }
}
