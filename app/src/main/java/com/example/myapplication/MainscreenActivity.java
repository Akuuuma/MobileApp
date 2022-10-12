package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainscreenActivity extends AppCompatActivity {
    private Button btLogar,btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        btLogar = findViewById(R.id.btLogar);
        btCadastrar = findViewById(R.id.btCadastrar);
    }
}