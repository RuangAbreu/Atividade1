package com.example.alunos.acertanumerodesafio;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.view.View;
import java.util.HashMap;
import android.util.Log;
import java.util.Map;

public class Score extends AppCompatActivity {

    Intent intencao;
    Bundle pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        TextView rank = (TextView) findViewById(R.id.textViewPontos);
        String conteudo = "";
        intencao = getIntent();
        pacote = intencao.getExtras();
        int[] tentativas = pacote.getIntArray("array");
        for(int i=0;i<5; i++){
            conteudo += Integer.toString(tentativas[i]) + "\n";
        }
        conteudo += "Highscore: " + Integer.toString(pacote.getInt("melhor"));
        rank.setText(conteudo);

    }
}
