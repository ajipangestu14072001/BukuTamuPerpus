package com.example.bukutamuperpustakaan.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bukutamuperpustakaan.adapter.QuestionAdapter;
import com.example.bukutamuperpustakaan.databinding.ActivityRatingBinding;
import com.example.bukutamuperpustakaan.model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatingActivity extends AppCompatActivity {
    private QuestionAdapter questionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRatingBinding binding = ActivityRatingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.runningText.setSelected(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));

        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question("1. Kesesuaian persyaratan pelayanan dengan jenis pelayanannya:", Arrays.asList("Tidak Sesuai", "Kurang Sesuai", "Sesuai", "Sangat Sesuai")));
        questionList.add(new Question("2. Kemudahan prosedur pelayanan di unit ini:", Arrays.asList("Tidak Mudah", "Kurang Mudah", "Mudah", "Sangat Mudah")));
        questionList.add(new Question("3. Kecepatan waktu dalam memberikan pelayanan:", Arrays.asList("Tidak Cepat", "Kurang Cepat", "Cepat", "Sangat Cepat")));
        questionList.add(new Question("4. Kewajaran biaya/tarif dalam pelayanan:", Arrays.asList("Sangat Mahal", "Cukup Mahal", "Murah", "Gratis")));
        questionList.add(new Question("5. Kesesuaian produk pelayanan antara yang tercantum dalam standar pelayanan dengan hasil yang diberikan:", Arrays.asList("Tidak Sesuai", "Kurang Sesuai", "Sesuai", "Sangat Sesuai")));
        questionList.add(new Question("6. Kompetensi/kemampuan petugas dalam pelayanan:", Arrays.asList("Tidak Kompeten", "Kurang Kompeten", "Kompeten", "Sangat Kompeten")));
        questionList.add(new Question("7. Perilaku petugas dalam pelayanan terkait kesopanan dan keramahan:", Arrays.asList("Tidak Sopan dan Ramah", "Kurang Sopan dan Ramah", "Sopan dan Ramah", "Sangat Sopan dan Ramah")));
        questionList.add(new Question("8. Pendapat tentang kualitas sarana dan prasarana:", Arrays.asList("Buruk", "Cukup", "Baik", "Sangat Baik")));
        questionList.add(new Question("9. Penanganan pengaduan pengguna layanan:", Arrays.asList("Tidak Ada", "Ada tetapi tidak berfungsi", "Berfungsi kurang maksimal", "Dikelola dengan baik")));

        questionAdapter = new QuestionAdapter(questionList);
        binding.recyclerview.setAdapter(questionAdapter);
    }
}