package com.example.quizapp.service;

import java.util.Optional;

import com.example.quizapp.Quiz;

public interface QuizService {
    Iterable<Quiz> selectAll();
    
    Optional<Quiz> selectOneById(Integer id);

    Optional<Quiz> selecOneRandamQuiz();
    
    Boolean checkQuiz(Integer id, Boolean mtAnswer);

    void insertQuiz(Quiz quiz);

    void updateQuiz(Quiz quiz);

    void deleteQuizByid(Integer id);
}
