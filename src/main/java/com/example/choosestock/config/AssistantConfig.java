package com.example.choosestock.config;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssistantConfig {
@Bean
    public ChatMemory chatMemory() {
    return MessageWindowChatMemory.withMaxMessages(20);
}
}
