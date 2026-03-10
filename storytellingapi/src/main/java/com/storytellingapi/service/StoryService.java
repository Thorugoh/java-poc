package com.storytellingapi.service;

import com.storytellingapi.domain.Story;
import com.storytellingapi.port.AiContentGenerator;
import com.storytellingapi.port.StoryRepository;

public class StoryService {
    private final StoryRepository repository;
    private final AiContentGenerator aiContentGenerator;

    public StoryService(StoryRepository repository, AiContentGenerator aiContentGenerator) {
        this.repository = repository;
        this.aiContentGenerator = aiContentGenerator;
    }

    public Story createStory(String title, String prompt){
        if(repository.existsByTitle(title)) {
            throw new IllegalArgumentException("A story with this title already exists.");
        }

        String generatedContent = aiContentGenerator.generateContent(prompt);

        if(generatedContent == null || generatedContent.isBlank()) {
            throw new IllegalStateException("Ai failed to generate content");
        }

        Story newStory = new Story(null, title, generatedContent);

        return repository.save(newStory);
    }
}
