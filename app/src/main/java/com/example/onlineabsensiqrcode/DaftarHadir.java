package com.example.onlineabsensiqrcode;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class DaftarHadir extends AppCompatActivity {
    private RecyclerView rvView;
    private ArrayList<Data> list = new ArrayList<>();
    private ArrayList<Data> list2 = new ArrayList<>();
    private TextView dtTm;

    FirebaseFirestore db;
    private static final String TAG = DaftarHadir.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarhadir);

        dtTm = findViewById(R.id.temu);
        rvView = findViewById(R.id.rv_dtlist);
        rvView.setHasFixedSize(true);

        db = FirebaseFirestore.getInstance();

        String data = getIntent().getStringExtra("data");

        dtTm.setText(data);

        db.collection("Pengembangan Aplikasi Mobile").document("Daftar Hadir")
                .collection(data)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());

                                Data isi = new Data();

                                StringBuilder fields = new StringBuilder("");
                                StringBuilder fields2 = new StringBuilder("");
                                StringBuilder fields3 = new StringBuilder("");

                                isi.setNama(fields.append(document.get("nama")).toString());
                                isi.setNim(fields2.append(document.get("nim")).toString());
                                isi.setHadir(fields3.append(document.get("kehadiran")).toString());
                                list.add(isi);
                            }
                            list2.addAll(list);

                            showRecyclerList();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    private void showRecyclerList(){
        rvView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter listHeroAdapter = new RecyclerViewAdapter(list2);
        rvView.setAdapter(listHeroAdapter);
    }
}
