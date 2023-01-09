package com.example.quizapp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.quizapp.service.QuizServiceImp;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.BooleanArraySerializer;

@SpringBootApplication
public class QuizappApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizappApplication.class, args);
		//.getBean(QuizappApplication.class).execute();
	}

	@Autowired
	QuizServiceImp service;

	private void execute(){
		//setUp();

		showList();
		showOne();
		UpdateQuiz();
		deleteQuiz();
		doQuiz();
	}
	
	private void setUp(){
		// create entity 
		Quiz quiz1 = new Quiz(null, "Spring FrameWork", true, "hyo");
		//entry
		service.insertQuiz(quiz1);
		System.out.println("entry:" + quiz1);

		// create entity 
		Quiz quiz2 = new Quiz(null, "Spring FrameWork", true, "hyo");
		//entry
		service.insertQuiz(quiz2);
		System.out.println("entry:" + quiz2);

	}
	private void showList(){
		System.out.println("start getting all record");
		Iterable<Quiz> quizList = service.selectAll();

		for(Quiz quiz_this : quizList){
			System.out.println(quiz_this);
		}

		System.out.println("finished getting all record");
	}

	private void showOne(){
		Optional<Quiz> target_quiz = service.selectOneById(1);

		if(target_quiz.isPresent()){
			//if target quiz is existed, then true
			System.out.println(target_quiz);	
		}else{
			System.out.println("target quiz is not existed");
		}

	}

	private void UpdateQuiz(){
		// update  record when id is 1 
		Quiz quiz1 = new Quiz(1, "Spring FrameWork", true, "kensho");
		//entry
		service.updateQuiz(quiz1);
		System.out.println("entry:" + quiz1);
	}

	private void deleteQuiz(){
		service.deleteQuizByid(3);
	}

	private void doQuiz(){
		Optional<Quiz> quiz = service.selecOneRandamQuiz();

		if(quiz.isPresent()){
			System.out.println("target quiz is existed");
		}else{
			System.out.println("target quiz is not existed");
		}
		Boolean answer = false;

		if(service.checkQuiz(quiz.get().getId(), answer)){
			System.out.println("Your answer is right");
		}else{
			System.out.println("Your answer is wrong");	
		}
	}
}
