package storytellingapi.service;

import com.storytellingapi.domain.Story;
import com.storytellingapi.port.AiContentGenerator;
import com.storytellingapi.port.StoryRepository;
import com.storytellingapi.service.StoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StoryServiceTest {

    @Mock
    private StoryRepository repository;

    @Mock
    private AiContentGenerator aiContentGenerator;

    @InjectMocks
    private StoryService storyService;

    @Test
    void shouldCreateStorySuccessfully() {
        // Arrange
        String title = "The Brave Knight";
        String prompt = "Write a story about a brave knight.";
        String generatedText = "Once upon a time, a brave knight...";
        Story expectedSavedStory = new Story("1", title, generatedText);

        // Instructing the mocks how t behave
        when(repository.existsByTitle(title)).thenReturn(false);
        when(aiContentGenerator.generateContent(prompt)).thenReturn(generatedText);
        when(repository.save(any(Story.class))).thenReturn(expectedSavedStory);

        // Act
        Story result = storyService.createStory(title, prompt);

        // Assert
        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals(title, result.getTitle());
        assertEquals(generatedText, result.getContent());

        verify(repository, times(1)).existsByTitle(title);
        verify(aiContentGenerator, times(1)).generateContent(prompt);
        verify(repository, times(1)).save(any(Story.class));
    }

    @Test
    void shouldFailWhenAiGeneratorThrows() {
        when(aiContentGenerator.generateContent("prompt")).thenThrow((new RuntimeException("API Down")));

        assertThrows(RuntimeException.class, () -> {
            storyService.createStory("Title", "prompt");
        });
    }

    @Captor
    private ArgumentCaptor<Story> storyCaptor;

    @Test
    void shouldCaptureStoryPassedToRepository() {
        when(repository.existsByTitle("Knight")).thenReturn(false);
        when(aiContentGenerator.generateContent("prompt")).thenReturn("Once upon a time...");

        storyService.createStory("Knight", "prompt");

        verify(repository).save(storyCaptor.capture());
        Story capturedStory = storyCaptor.getValue();

        assertEquals("Knight", capturedStory.getTitle());
        assertEquals("Once upon a time...", capturedStory.getContent());
    }


    @Spy
    private List<String> realList = new ArrayList<>();

    @Test
    void shouldSpyOnRealObject() {
        Story realStory = spy(new Story("1", "The Knight", "text content"));

        doReturn("Another text").when(realStory).getContent();

        assertEquals("1", realStory.getId());
        assertEquals("The Knight", realStory.getTitle()); // Real behavior
        assertEquals("Censored text", realStory.getContent()); // Faked behavior
    }
}
