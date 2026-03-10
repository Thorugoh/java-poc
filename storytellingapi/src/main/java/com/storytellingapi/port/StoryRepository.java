package com.storytellingapi.port;

import com.storytellingapi.domain.Story;

public interface StoryRepository {
    Story save(Story story);
    boolean existsByTitle(String title);
}
