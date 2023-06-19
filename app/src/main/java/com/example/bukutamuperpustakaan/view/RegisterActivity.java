package com.example.bukutamuperpustakaan.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.bukutamuperpustakaan.MainActivity;
import com.example.bukutamuperpustakaan.R;
import com.example.bukutamuperpustakaan.databinding.ActivityRegisterBinding;
import com.example.bukutamuperpustakaan.model.Users;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private final String[] pendidikan = {"SD/MI", "SMP/MTS", "SMA/SMK", "Sarjana/Terapan"};
    private final String[] kelamin = {"Laki-laki", "Perempuan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterBinding binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ArrayAdapter<String> kategoriPendidikan = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, pendidikan);
        ArrayAdapter<String> kategoriKelamin = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, kelamin);
        binding.pendidikan.setAdapter(kategoriPendidikan);
        binding.jenisKelamin.setAdapter(kategoriKelamin);
        String email, userID = null, nama;
        Intent intent = getIntent();
        if (intent != null) {
            email = intent.getStringExtra("email");
            userID = intent.getStringExtra("userId");
            nama = intent.getStringExtra("nama");
            binding.email.setText(email);
            binding.name.setText(nama);
        }
        String finalUserID = userID;
        binding.register.setOnClickListener(view1 -> {
            String name = Objects.requireNonNull(binding.name.getText()).toString();
            String fullEmail = Objects.requireNonNull(binding.email.getText()).toString();
            String job =  Objects.requireNonNull(binding.job.getText()).toString();
            String education = binding.pendidikan.getText().toString();
            String gender = binding.jenisKelamin.getText().toString();
            String age = Objects.requireNonNull(binding.umur.getText()).toString();
            String address = Objects.requireNonNull(binding.alamat.getText()).toString();

//            System.out.println(finalUserID + name + fullEmail + job + education + gender + age +address);

            uploadUser(finalUserID, name, fullEmail, job, education, gender, age, address);
//            startActivity(new Intent(this, MainActivity.class));
//            finish();
        });
    }

    private void uploadUser(String userId, String name, String email, String job, String education, String gender, String age, String address) {
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users");

        Users user = new Users(userId, name, email, job, education, gender, age, address);
        usersRef.child(userId).setValue(user)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(RegisterActivity.this, "User data uploaded successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    finish();
                })
                .addOnFailureListener(e -> Toast.makeText(RegisterActivity.this, "Failed to upload user data: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }

}