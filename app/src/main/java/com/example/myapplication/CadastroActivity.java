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

public class CadastroActivity extends AppCompatActivity {

    private EditText etName, etEmail,etSenha;
    private FirebaseAuth rauth;
    private Usuario nu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        Button btcadastrar = findViewById(R.id.btcadastrar);
        rauth = FirebaseAuth.getInstance();



        btcadastrar.setOnClickListener(view -> {
            receberdados();
            criarlogin();
        });
    }

    private void receberdados() {
        if(etName.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty() || etSenha.getText().toString().isEmpty()){
            Toast.makeText(this, "Preencha todos os campos",
                    Toast.LENGTH_LONG).show();
        }else{
            nu = new Usuario();
            nu.setName(etName.getText().toString());
            nu.setEmail(etEmail.getText().toString());
            nu.setSenha(etSenha.getText().toString());
        }

    }

    private void criarlogin() {
        rauth.createUserWithEmailAndPassword(nu.getEmail(), nu.getSenha()).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()) {
                FirebaseUser user = rauth.getCurrentUser();
                assert user != null;
                nu.setId(user.getUid());
                nu.salvardados();
                startActivity(new Intent(CadastroActivity.this, LoginActivity.class));
            } else {
                Toast.makeText(CadastroActivity.this, "ERRO NO PROCESSO",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}

