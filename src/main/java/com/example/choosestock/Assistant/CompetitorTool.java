package com.example.choosestock.Assistant;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiLanguageModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CompetitorTool {

private final ChatLanguageModel model;

    public CompetitorTool(@Value("${langchain4j.open-ai.chat-model.api-key}") String openAIApiKey) {
        this.model = OpenAiChatModel.builder()
                .apiKey(openAIApiKey)
                .modelName("gpt-4o-mini")
                .temperature(0.7)
                .build();
    }


//    ChatLanguageModel model = OpenAiChatModel.builder().modelName("gpt-4o-mini")
//            .build();

    @Tool("Find Competitors Finds competitors for a given stock ticker with details")
    public String findCompetitors(String stockTicker) {
        String prompt = """ 
                search for three competitors of the company with ticker "%s".
               Provide:
               - Name of the competitor
               - Market share percentage
               - A short explanation (50 words) why this is a competitor.
              """.formatted(stockTicker);
        return model.generate(prompt);
    }
}
