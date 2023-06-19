package com.example.bukutamuperpustakaan.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bukutamuperpustakaan.MainActivity;
import com.example.bukutamuperpustakaan.R;
import com.example.bukutamuperpustakaan.databinding.ActivityOnboardBinding;

public class OnboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityOnboardBinding binding = ActivityOnboardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.btnloti.setOnClickListener(view1 -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}