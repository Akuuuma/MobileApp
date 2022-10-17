package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainscreenActivity extends AppCompatActivity {
    private Button btLogar,btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        btLogar = findViewById(R.id.btLogar);
        btCadastrar = findViewById(R.id.btcadastrar);

        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telalogin();
            }
        });

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telacadastrar();
            }
        });
    }

    private void telacadastrar() {
        startActivity(new Intent(this,CadastroActivity.class));
    }

    private void telalogin() {
        startActivity(new Intent(this,LoginActivity.class));
    }
}