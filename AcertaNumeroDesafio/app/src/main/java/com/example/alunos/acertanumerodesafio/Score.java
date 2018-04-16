package com.example.alunos.acertanumerodesafio;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    Intent intencao;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView score = (TextView) findViewById(R.id.textViewPontos);
        String conteudo = "";
        intencao = getIntent();
        bundle = intencao.getExtras();
        int[] tentativas = bundle.getIntArray("array");
        for(int i=0;i<5; i++){
            conteudo += Integer.toString(tentativas[i]) + "\n";
        }
        conteudo += "Highscore: " + Integer.toString(bundle.getInt("melhor"));
        score.setText(conteudo);

    }
}
