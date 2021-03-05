package com.example.onlineabsensiqrcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DaftarPertemuan extends AppCompatActivity {
    private TextView pt1, pt2, pt3, pt4, pt5, pt6, pt7, pt8, pt9, pt10, pt11, pt12, pt13, pt14, pt15, pt16;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarpertemuan);

        pt1 = findViewById(R.id.tv1);
        pt2 = findViewById(R.id.tv2);
        pt3 = findViewById(R.id.tv3);
        pt4 = findViewById(R.id.tv4);
        pt5 = findViewById(R.id.tv5);
        pt6 = findViewById(R.id.tv6);
        pt7 = findViewById(R.id.tv7);
        pt8 = findViewById(R.id.tv8);
        pt9 = findViewById(R.id.tv9);
        pt10 = findViewById(R.id.tv10);
        pt11 = findViewById(R.id.tv11);
        pt12 = findViewById(R.id.tv12);
        pt13 = findViewById(R.id.tv13);
        pt14 = findViewById(R.id.tv14);
        pt15 = findViewById(R.id.tv15);
        pt16 = findViewById(R.id.tv16);

        pt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 1");
                startActivity(intent);
            }
        });

        pt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 2");
                startActivity(intent);
            }
        });

        pt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 3");
                startActivity(intent);
            }
        });

        pt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 4");
                startActivity(intent);
            }
        });

        pt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 5");
                startActivity(intent);
            }
        });

        pt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 6");
                startActivity(intent);
            }
        });

        pt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 7");
                startActivity(intent);
            }
        });

        pt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 8");
                startActivity(intent);
            }
        });

        pt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 9");
                startActivity(intent);
            }
        });

        pt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 10");
                startActivity(intent);
            }
        });

        pt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 11");
                startActivity(intent);
            }
        });

        pt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 12");
                startActivity(intent);
            }
        });

        pt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 13");
                startActivity(intent);
            }
        });

        pt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 14");
                startActivity(intent);
            }
        });

        pt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 15");
                startActivity(intent);
            }
        });

        pt16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPertemuan.this, DaftarHadir.class);
                intent.putExtra("data", "Pertemuan 16");
                startActivity(intent);
            }
        });
    }
}
