package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.SaveStation.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail,etSenha;
    private Button btlogar;
    private FirebaseAuth rauth;
    private Usuario nu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.edtEmail);
        etSenha = findViewById(R.id.edtSenha);
        btlogar = findViewById(R.id.btlogar);
        rauth = FirebaseAuth.getInstance();

        btlogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pegardados();
                login();
            }
        });
    }
    private void pegardados() {
        nu = new Usuario();
        nu.setEmail(etEmail.getText().toString());
        nu.setSenha(etSenha.getText().toString());

    }

    private void login() {
        rauth.signInWithEmailAndPassword(nu.getEmail(),nu.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser nuser = rauth.getCurrentUser();
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Autenticação falhou",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }




}