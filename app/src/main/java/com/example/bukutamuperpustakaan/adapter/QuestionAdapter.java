package com.example.bukutamuperpustakaan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bukutamuperpustakaan.R;
import com.example.bukutamuperpustakaan.model.Question;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {
    private List<Question> questions;

    public QuestionAdapter(List<Question> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuestionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.questionTextView.setText(question.getQuestionText());

        List<String> answerOptions = question.getAnswerOptions();
        holder.option1RadioButton.setText(answerOptions.get(0));
        holder.option2RadioButton.setText(answerOptions.get(1));
        holder.option3RadioButton.setText(answerOptions.get(2));
        holder.option4RadioButton.setText(answerOptions.get(3));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        public TextView questionTextView;
        public RadioButton option1RadioButton, option2RadioButton, option3RadioButton, option4RadioButton;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
            option1RadioButton = itemView.findViewById(R.id.option1RadioButton);
            option2RadioButton = itemView.findViewById(R.id.option2RadioButton);
            option3RadioButton = itemView.findViewById(R.id.option3RadioButton);
            option4RadioButton = itemView.findViewById(R.id.option4RadioButton);
        }
    }
}

