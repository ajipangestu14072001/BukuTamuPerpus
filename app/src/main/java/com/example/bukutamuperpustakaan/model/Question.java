package com.example.bukutamuperpustakaan.model;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> answerOptions;
    private int selectedOptionIndex = -1;

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

    public int getSelectedOptionIndex() {
        return selectedOptionIndex;
    }

    public void setSelectedOptionIndex(int selectedOptionIndex) {
        this.selectedOptionIndex = selectedOptionIndex;
    }

    public String getSelectedOption() {
        if (selectedOptionIndex != -1) {
            return answerOptions.get(selectedOptionIndex);
        }
        return null;
    }
}


