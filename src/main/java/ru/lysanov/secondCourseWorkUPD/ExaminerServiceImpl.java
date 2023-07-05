package ru.lysanov.secondCourseWorkUPD;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    Random random;

    QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionsForExam = new HashSet<>();
        while (questionsForExam.size() < amount) {
            Question random = questionService.getRandomQuestion();
            questionsForExam.add(random);
        }
        return questionsForExam;
    }
}
