package ru.lysanov.secondCourseWorkUPD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    Set<Question> questions = new HashSet<>();
    Question question = new Question("question", "answer");

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void setUp() {
        questions.add(question);
    }

    @Test
    public void shouldGetQuestionsRight() {
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(question);

        Collection<Question> expectedValue = questions;
        Collection<Question> actualValue = out.getQuestions(1);

        assertEquals(expectedValue, actualValue);
    }
}
