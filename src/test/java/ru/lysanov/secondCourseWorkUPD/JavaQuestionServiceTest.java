package ru.lysanov.secondCourseWorkUPD;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();

    public static Stream<Arguments> provideParamsForAddTest() {
        return Stream.of(
                Arguments.of("question", "answer")
        );
    }

    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(new Question("question", "question"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddTest")
    public void shouldAddRight(String question, String answer) {
        Question expectedValue = new Question("question", "answer");
        Question result = out.add(question, answer);
        assertEquals(expectedValue, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldAddRight(Question question) {
        Question expectedValue = question;
        Question result = out.add(question);
        assertEquals(expectedValue, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldRemoveRight(Question question) {
        Question expectedValue = question;
        Question result = out.remove(question);
        assertEquals(expectedValue, result);
    }

    @Test
    public void shouldGetAllRight() {
        Collection<Question> expectedValue = new HashSet<>();
        Question question = new Question("question", "answer");
        expectedValue.add(question);

        out.add(question);
        Collection<Question> result = out.getAll();
        assertEquals(expectedValue, result);
    }

    @Test
    public void shouldGetRandomQuestionRight() {
        Question question = new Question("question", "answer");
        Question expectedValue = question;

        out.add(question);
        Question result = out.getRandomQuestion();
        assertEquals(expectedValue, result);
    }
//    тк тут используется рандом то проверяю на выпадание рандома из сета одного значения
}
