package com.openrouter.example.controller;

import com.openrouter.example.dto.ChatRequest;
import com.openrouter.example.service.OpenRouterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/openrouter/ai/")
@Slf4j
@RequiredArgsConstructor
public class ChatController {

    private final ChatModel chatModel;

    private final OpenRouterService openRouterService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/all/models")
    public List<String> getAllModels() {
        return openRouterService.getAllModels();
    }

    @PostMapping("/chat/{message}")
    public String chat(@PathVariable String message) {
        return chatModel.call(message);
    }

    @PostMapping("/chat")
    public String chat(@RequestBody ChatRequest request) {
        //return chatModel.call(request.getMessage());
        return openRouterService.getCompletion(request.getModel(), request.getMessage());
    }
}