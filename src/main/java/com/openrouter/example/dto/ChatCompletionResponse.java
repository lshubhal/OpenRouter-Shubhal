package com.openrouter.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChatCompletionResponse {
    private List<Choice> choices;
    // getters and setters
}
