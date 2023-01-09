package com.example.quizapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.quizapp.Quiz;
import com.example.quizapp.QuizRepository;

@Service
@Transactional
public class QuizServiceImp implements QuizService{

    @Autowired
    QuizRepository reposity;

    @Override
    public Iterable<Quiz> selectAll(){
        return reposity.findAll();
    }
    
    @Override
    public Optional<Quiz> selectOneById(Integer id){
        return reposity.findById(id);
    }

    @Override
    public Optional<Quiz> selecOneRandamQuiz(){
        Integer id = reposity.getRandomId();
        
        if(id == null){
            return Optional.empty();
        }

        return reposity.findById(id);
    }
    
    @Override
    public Boolean checkQuiz(Integer id, Boolean myAnswer){
        Boolean result = false;

        Optional<Quiz> target_quiz = reposity.findById(id);

        if(target_quiz.isPresent()){
           Quiz quiz = target_quiz.get();
           
           if(quiz.getAnswer().equals(myAnswer)){
                result = true;
           }
        }

        return result;
    }

    @Override
    public void insertQuiz(Quiz quiz){
        reposity.save(quiz);
    }

    @Override
    public void updateQuiz(Quiz quiz){
        reposity.save(quiz);
    }

    @Override
    public void deleteQuizByid(Integer id){
        reposity.deleteById(id);
    }
}
