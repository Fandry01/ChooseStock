package com.example.choosestock.Assistant;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CompetitorTool {

private final ChatLanguageModel model;
private static final Logger LOGGER = LoggerFactory.getLogger(CompetitorTool.class);

    public CompetitorTool(@Value("${OPENAI_API_KEY}") String openAIApiKey) {
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
