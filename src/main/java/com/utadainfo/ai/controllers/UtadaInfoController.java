package com.utadainfo.ai.controllers;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utada")
public class UtadaInfoController {
    private final OpenAiChatClient chatClient;

    public UtadaInfoController(OpenAiChatClient chatClient){
        this.chatClient = chatClient;
    }

    @GetMapping("/about")
    public String aboutChat(@RequestParam (value = "message",
            defaultValue = "Send a brief description about Utada Hikaru and the official website") String message){
        return chatClient.call(message);
    }

    @GetMapping("/top-albums")
    public ChatResponse topAlbumsChat(@RequestParam (value = "message",
            defaultValue = "What are the best selling albums from Utada Hikaru?") String message){
        return chatClient.call(new Prompt(message));
    }
}
