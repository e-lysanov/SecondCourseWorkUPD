package ru.lysanov.secondCourseWorkUPD;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    Random random;

    QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
