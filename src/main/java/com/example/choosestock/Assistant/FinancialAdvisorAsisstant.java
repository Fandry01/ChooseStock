package com.example.choosestock.Assistant;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface FinancialAdvisorAsisstant {
    @SystemMessage("""
            You are a polite stock advisor asisstant
            """)
    String chat(String userMessage);
}
