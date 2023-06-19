package com.example.bukutamuperpustakaan.model;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> answerOptions;

    public Question(String questionText, List<String> answerOptions) {
        this.questionText = questionText;
        this.answerOptions = answerOptions;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getAnswerOptions() {
        return answerOptions;
    }
}
