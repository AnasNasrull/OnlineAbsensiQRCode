package com.example.onlineabsensiqrcode;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    private Button btSignUp2;
    private EditText etEmail2, etPassword2, Nama, NIM;
    private String nama, nim;
    private TextView masuk;

    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener fStateListener;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private static final String TAG = SignUp.class.getSimpleName();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fAuth = FirebaseAuth.getInstance();

        fStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.v(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    Log.v(TAG, "onAuthStateChanged:signed_out");
                }
            }

        };

        btSignUp2 = findViewById(R.id.bt_signup2);
        etEmail2 = findViewById(R.id.et_email2);
        etPassword2 = findViewById(R.id.et_password2);
        Nama = findViewById(R.id.et_nama);
        NIM = findViewById(R.id.et_nim);
        masuk = findViewById(R.id.tx_masuk);

        btSignUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(Nama.getText().toString().trim())) {
                    Toast.makeText(getApplicationContext(), "Enter your name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(NIM.getText().toString().trim())) {
                    Toast.makeText(getApplicationContext(), "Enter your NIM!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etEmail2.getText().toString().trim())) {
                    Toast.makeText(getApplicationContext(), "Enter your email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etPassword2.getText().toString().trim())) {
                    Toast.makeText(getApplicationContext(), "Enter your password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                nama = Nama.getText().toString();
                nim = NIM.getText().toString();

                signUp(etEmail2.getText().toString(), etPassword2.getText().toString());
            }
        });

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fAuth.signOut();

                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void signUp(final String email, String password){

        fAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if (!task.isSuccessful()) {
                            task.getException().printStackTrace();
                            Toast.makeText(SignUp.this, "Proses Pendaftaran Gagal",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Map<String, Object> user = new HashMap<>();
                            user.put("email", email);
                            user.put("nama", nama);
                            user.put("nim", nim);

                            db.collection("users").document(email).set(user)
                                    .addOnSuccessListener(new OnSuccessListener < Void > () {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(SignUp.this, "Proses Pendaftaran Berhasil",
                                                    Toast.LENGTH_SHORT).show();

                                            fAuth.signOut();

                                            Intent intent = new Intent(SignUp.this, MainActivity.class);
                                            startActivity(intent);
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(SignUp.this, "ERROR" + e.toString(),
                                                    Toast.LENGTH_SHORT).show();
                                            Log.d("TAG", e.toString());
                                        }
                                    });

                            Map<String, Object> hadir = new HashMap<>();
                            hadir.put("nama", nama);
                            hadir.put("nim", nim);
                            hadir.put("email", email);
                            hadir.put("kehadiran", "Tidak Hadir");

                            for (int i = 1; i<=16; i++) {
                                db.collection("Pengembangan Aplikasi Mobile")
                                        .document("Daftar Hadir")
                                        .collection("Pertemuan "+ i)
                                        .document(nim).set(hadir)
                                        .addOnSuccessListener(new OnSuccessListener< Void >() {
                                            @Override
                                            public void onSuccess(Void aVoid) { }

                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.d("TAG", e.toString());
                                            }
                                        });
                            }
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        fAuth.addAuthStateListener(fStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (fStateListener != null) {
            fAuth.removeAuthStateListener(fStateListener);
        }
    }
}