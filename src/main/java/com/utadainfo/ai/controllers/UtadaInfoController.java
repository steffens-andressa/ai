package com.utadainfo.ai.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/utada")
public class UtadaInfoController {
    private final OpenAiChatClient chatClient;

    public UtadaInfoController(OpenAiChatClient chatClient){
        this.chatClient = chatClient;
    }

    @Operation(summary = "Provides a summary about Utada Hikaru")
    @GetMapping("/about")
    public String about(@RequestParam (value = "message",
            defaultValue = "Send a brief description about Utada Hikaru and the official website") String message){
        return chatClient.call(message);
    }

    @Operation(summary = "Lists the best selling albums")
    @GetMapping("/top-albums")
    public ChatResponse topAlbums(@RequestParam (value = "message",
            defaultValue = "What are the best selling albums from Utada Hikaru?") String message){
        return chatClient.call(new Prompt(message));
    }

    @Operation(summary = "Provides a summary about a single or album")
    @GetMapping("/title-info")
    public String titleInfo(@Parameter (schema = @Schema(allowableValues = {"Single", "Album"})) String type,
                                @RequestParam (value = "title", defaultValue = "First Love") String title) {
        PromptTemplate promptTemplate = new PromptTemplate("""
                Send me a brief summary about the {type} {title} from Utada Hikaru and list all the tracks.
                """);
        promptTemplate.add("type", type);
        promptTemplate.add("title", title);
        return this.chatClient.call(promptTemplate.create()).getResult().getOutput().getContent();
    }

    @Operation(summary = "Translates a track")
    @GetMapping("/track-translation")
    public String translateTrack(@RequestParam (value = "track", defaultValue = "First Love") String track) {
        PromptTemplate promptTemplate = new PromptTemplate("""
                Send the lyrics in romaji and translate this track {track} from Utada Hikaru
                """);
        promptTemplate.add("track", track);
        return this.chatClient.call(promptTemplate.create()).getResult().getOutput().getContent();
    }

    @Operation(summary = "List Utada Hikaru's live performances asynchronously")
    @GetMapping("/live-concerts-async")
    public Flux<ChatResponse> listLiveConcerts(@RequestParam(value = "message",
            defaultValue = "List all live perfonmances from Utada Hikaru, when and where they occurred.") String message){
        return this.chatClient.stream(new Prompt(message));
    }
}
