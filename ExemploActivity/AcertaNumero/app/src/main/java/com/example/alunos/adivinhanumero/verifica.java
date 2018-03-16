package com.example.alunos.adivinhanumero;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class verifica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica);
        Intent intencao = getIntent();
        Bundle pacote = intencao.getExtras();

        String placar = pacote.getString("numero", "tentativa");
        TextView txtResultado = (TextView) findViewById(R.id.txtPlacar);
        txtPlacar.setText(String.format("Placar!", placar));
    }

}
