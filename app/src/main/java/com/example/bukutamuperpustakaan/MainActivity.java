package com.example.bukutamuperpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.example.bukutamuperpustakaan.databinding.ActivityMainBinding;
import com.example.bukutamuperpustakaan.view.OnboardActivity;
import com.example.bukutamuperpustakaan.view.RatingActivity;
import com.example.bukutamuperpustakaan.view.SplashActivity;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {
    Bitmap bitmap;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        if (intent != null) {
            userID = intent.getStringExtra("userId");
        }
        generateCodeQR(binding, userID);

        binding.refresh.setOnClickListener(view1 -> {
            Intent intent1 = new Intent(MainActivity.this, RatingActivity.class);
            intent1.putExtra("userId", userID);
            startActivity(intent1);
        });
    }

    private void generateCodeQR(ActivityMainBinding binding, String value) {
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int dimen = Math.min(width, height);
        dimen = dimen * 3 / 4;
        QRGEncoder qrgEncoder = new QRGEncoder(value, null, QRGContents.Type.TEXT, dimen);
        qrgEncoder.setColorBlack(Color.WHITE);
        qrgEncoder.setColorWhite(Color.BLACK);
        try {
            bitmap = qrgEncoder.getBitmap();
            binding.imageViewQR.setImageBitmap(bitmap);
        } catch (Exception ignored) {

        }
    }
}